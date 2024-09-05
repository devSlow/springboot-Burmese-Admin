package com.yupi.springbootinit.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yupi.springbootinit.model.dto.vocabulary.AddVocabularyRequest;
import com.yupi.springbootinit.model.entity.Examplesentence;
import com.yupi.springbootinit.model.entity.Translation;
import com.yupi.springbootinit.model.entity.Vocabulary;
import com.yupi.springbootinit.service.CibookService;
import com.yupi.springbootinit.service.ExamplesentenceService;
import com.yupi.springbootinit.service.TranslationService;
import com.yupi.springbootinit.service.VocabularyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 词汇相关接口
 */
@RestController
@RequestMapping("/vocabulary")
@Slf4j
public class VocabularyController {
    /**
     * @author slow
     * 添加词汇
     */
    @Resource
    VocabularyService vocabularyService;
    @Resource
    TranslationService translationService;
    @Resource
    ExamplesentenceService examplesentenceService;
    @Resource
    CibookService cibookService;

    @PostMapping("/add")
    @Transactional
    public void addVocabulary(@RequestBody AddVocabularyRequest request) {
        vocabularyService.addVocabulary(request);
    }

    /**
     * @author slow
     * 删除词汇
     */
    @DeleteMapping("/delete")
    public void deleteVocabulary(Integer id) {
        log.info("删除词汇...：{}", id);
        vocabularyService.removeById(id);
    }

    /**
     * @author slow
     * 修改词汇 传入修改的id和修改之后的内容
     */
    @PutMapping("/update/{id}")
    public void updateVocabulary(@PathVariable Integer id, String vocabulary_chars) {
        log.info("词汇：{},更新为：{}", id, vocabulary_chars);
        vocabularyService.updateVocabularyById(id, vocabulary_chars);
    }

    /**
     * @author slow
     * 根据输入内容查询词汇，不填则查询全部词汇
     */
    @GetMapping("/get")
    public List<Vocabulary> getVocabulary(@RequestParam(required = false) String vocabulary_chars) {
        log.info("查询词汇...：{}", vocabulary_chars);
        QueryWrapper<Vocabulary> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(vocabulary_chars != null, "vocabulary_chars", vocabulary_chars);
        List<Vocabulary> list = vocabularyService.list(queryWrapper);
        return list;
    }
}
