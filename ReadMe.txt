Hi,

General Comments:
1. I have added comments starting from: //Karthik  to explain what I might be doing or what might NOT be.
2. I haven't used any design pattern as I think the current requirement doesn't demand, however it would / could be used when necessary. (Factory / Singleton common ones that can be used)
3. Based on the assumption I haven't validated too much as it was safe to assume that the data would be valid, however I have added very basic validations.
4. I haven't strictly coded for multithreading as of now.
5. The code might not pass for test case where there is an invalid / unknown type in the multiple TLV string (not having single TLV per line)

Usage:

1. You can find the jar with the name: tlvprocessor.txt_rename_to_jar. Rename to have the .jar extension to run.
2. You can directly use the jar as stated  in the exercise.
3. If you want to try something in the code, I have used eclipse during my development.
4. The maven build takes care of generating the jar in the required fashion.