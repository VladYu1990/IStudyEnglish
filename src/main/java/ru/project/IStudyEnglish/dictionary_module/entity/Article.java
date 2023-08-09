package ru.project.IStudyEnglish.dictionary_module.entity;

public class Article {

    public static String addArticle(String str,int codeOfPartSpeech){
        String returnStr = null;
        if(codeOfPartSpeech == 1){
            char firstChar = str.charAt(0);
            if (firstChar == 'a'||
                    firstChar == 'e'||
                    firstChar == 'i'||
                    firstChar == 'o'||
                    firstChar == 'u'||
                    firstChar == 'y'){
                                returnStr= "an " + str;
            }
            else{
                returnStr = "a " + str;
            }
        }
        else if (codeOfPartSpeech==2) {
            returnStr = "to " + str;
        }
        else {returnStr = str;}

        return returnStr;
    }
}
