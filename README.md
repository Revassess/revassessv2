# REVASSESS
**This assessment will gauge your understanding of the content to this point**

Make sure you add your email address to the travis.yml file.

For this assessment, you are able to use any resources you wish,
aside from other people. You are allowed to do any research needed,
but are not allowed to communicate with other associates about the 
evaluation.

There are six tiers for this assessment that will get more difficult
with each tier. Beginning with Tier 3, they will begin working off 
previous work. So for example, tier 4 may use a db table constructed 
in tier 3. Therefore, it is vital that each tier be completed before
moving on to the next. Also, the automation will check each tier 
iterably and will stop when it reaches an incomplete tier.

You will begin by moving branches to tier 1 and completing
the prompts given in the markdown file. after the successful
completion of the requirements, you can move to the tier 2
branch and complete those requirements. tiers 3 through 6 
will all be in the same tier.

To submit your work, push your changes to the respective 
branch. You will recieve an email to the address you 
supplied in the configuration file. 

Your score is a compilation of the number of tiers completed
and the total number of points accumulated. It is important 
that this is understood and it will be your decision if you
continue to gather points on the current tier or move on to
the next (the minimum number of points to move on to the 
next tier is not equal to the total number of points able to 
be acquired).

**WARNING**

Do not alter the files in the test folder for any reason
whatsoever.

**Git Instructions**

Knowledge of using git is required for this assessment. Use the
following commands for the following. 

### Checkout a new branch
> git checkout branchname

### Push code to branch
> git add *  (will add all files to staging)

> git commit -m "enter a commit message here"  (this will commit the files from staging and ready them to push)

> git push  (push the files to git server)

**Run Tests Locally**
 You can either run the tests from the command line
 or from your ide. To run the tests for the entire
 tier, run the test labeled "TierXTests" where X is the
 tier number. To run the tier from the command line, 
 you will need maven installed. Run 
 "mvn test -Dtest=TierXTests" where X is the tier number.
 
 > Note: you must be on the branch for the tier you want to test
 to be able to test it. Tests will need to be run locally and 
 you will need to look into the tests to see why they are failing.
 You are not to alter any of the tests, but it is essential that
 you know what you need to do to pass the tier.
