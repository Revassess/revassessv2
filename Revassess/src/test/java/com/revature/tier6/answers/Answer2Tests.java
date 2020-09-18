package com.revature.tier6.answers;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.servlet.RevassessServlet;

import dev.ranieri.assesors.RevAssess;
import dev.ranieri.assesors.RevaTest;

/**
 * prompt: Implement a single servlet 
 * that can provide flashcard data by 
 * consuming its mapped endpoint. The 
 * data should be in json format and 
 * information should come from the 
 * database using the entities created 
 * in tier 4.
 */
@ExtendWith(RevAssess.class)
public class Answer2Tests {

    private HttpServlet serv;
    private Set<String> jsonKeys;
    private Method doGet;
    @BeforeEach
    public void setup() throws SecurityException, NoSuchMethodException {
        RevassessServlet rev = new RevassessServlet();
        if (rev instanceof Servlet) {
            serv = rev;
        } else {
            serv = new HttpServlet() {
                private static final long serialVersionUID = 1L;
                @Override
                protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                        throws ServletException, IOException {
                }
            };
        }
        // Arrays.asList(serv.getClass().getDeclaredMethods()).stream().forEach(System.out::println);
        doGet = serv.getClass().getSuperclass().getDeclaredMethod("doGet", HttpServletRequest.class, HttpServletResponse.class);
        doGet.setAccessible(true);
        // serv.getClass().
    }

    @BeforeEach
    public void setupJson(){
        jsonKeys = new HashSet<>();
        jsonKeys.add("question");
        jsonKeys.add("answer");
        jsonKeys.add("id");
        jsonKeys.add("category");
    }

    @RevaTest(tier = 6, points = 200)
    public void test2() throws ServletException, IOException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException {
    	try {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);
        doGet.invoke(serv, request, response);
        writer.flush();
        ObjectMapper om = new ObjectMapper();
        String output = stringWriter.toString();
        TypeReference<Map<String, Object>> t = new TypeReference<Map<String,Object>>() {};
        Map<String, Object> servletJson = (Map<String, Object>) om.readValue(output, t);
        System.out.println(servletJson);
        System.out.println(jsonKeys);
        jsonKeys.stream().forEach(s->assertTrue(servletJson.containsKey(s)));
    	} catch(Exception e) {
    		fail();
    	}
    }

    

    
}
