package io.swagger.api.impl;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.vdurmont.emoji.EmojiParser;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Akashravindranath on 7/27/19.
 */
public class TranslateText {

    public String translateText(String text){

        // Instantiates a client
        Translate translate = TranslateOptions.getDefaultInstance().getService();

        text = EmojiParser.parseToAliases(text);
        String detectedLanguage = translate.detect(text).getLanguage();
        if(StringUtils.equalsIgnoreCase(detectedLanguage, "en")) {
            return text;
        }

        try{
            Translation translation =
                    translate.translate(
                            text,
                            Translate.TranslateOption.sourceLanguage(detectedLanguage),
                            Translate.TranslateOption.targetLanguage("en"));


            return translation.getTranslatedText();

        }
        catch (Exception e){
            return null;
        }

    }

}

