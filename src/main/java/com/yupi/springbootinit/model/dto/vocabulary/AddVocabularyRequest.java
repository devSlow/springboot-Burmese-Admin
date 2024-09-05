package com.yupi.springbootinit.model.dto.vocabulary;

import com.yupi.springbootinit.model.entity.Examplesentence;
import com.yupi.springbootinit.model.entity.Translation;
import com.yupi.springbootinit.model.entity.Vocabulary;
import lombok.Data;

import java.util.List;
@Data
public class AddVocabularyRequest {
    private Vocabulary vocabulary;
    private List<Translation> translation;
    private List<Examplesentence> examplesentence;
}
