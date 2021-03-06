package com.que.votesys.web;

import com.que.votesys.data.AnswerRepo;
import com.que.votesys.data.OptionRepo;
import com.que.votesys.data.QuestionRepo;
import com.que.votesys.model.Answer;
import com.que.votesys.model.Option;
import com.que.votesys.model.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping
@SessionAttributes("optionsMap")
public class MainController {

    private OptionRepo optionRepo;
    private QuestionRepo questionRepo;
    private AnswerRepo answerRepo;

    @Autowired
    public MainController(OptionRepo optionRepo, QuestionRepo questionRepo, AnswerRepo answerRepo) {
        this.optionRepo = optionRepo;
        this.questionRepo = questionRepo;
        this.answerRepo = answerRepo;
    }

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    // 投票主页响应，返回一个答案-选项集的映射
    @GetMapping("/vote")
    public String showVoteForm(Model model) {
        List<Question> questionList = new ArrayList<>();
        questionRepo.findAll().forEach(i -> questionList.add(i));

        Map<Question, List<Option>> optionsMap = new HashMap<>();
        List<Option> optionList = new ArrayList<>();
        optionRepo.findAll().forEach(i -> optionList.add(i));
        for (int i = 0; i < questionList.size(); i++) {
            optionsMap.put(questionList.get(i), filterByQuestionId(optionList, questionList.get(i).getId()));
        }
        model.addAttribute("optionsMap", optionsMap);

        return "vote";
    }

    // 投票判定响应
    @PostMapping("/votepost")
    public String processVote(HttpServletRequest request) {
        List<Answer> answerList = new ArrayList<>();
        Enumeration<String> enu = request.getParameterNames();

        while (enu.hasMoreElements()) {
            String QAStr = enu.nextElement();
            String pattern = "\\d#\\w*";
            boolean isValidQAStr = Pattern.matches(pattern, QAStr);
            if (isValidQAStr) {
                int Qid = Integer.parseInt(QAStr.split("#")[0]);
                int OptId = Integer.parseInt(request.getParameter(QAStr).split("#")[0]);
                answerList.add(new Answer(Qid, OptId, request.getLocalAddr()));
            }

        }
        answerRepo.saveAll(answerList);

        return "votesuccess";
    }

    // 问卷结果页面
    @GetMapping("/result")
    public String showVoteDiagram(@ModelAttribute("optionsMap") Map<Question, List<Option>> optionsMap) {

        return "result";
    }

    @CrossOrigin // 允许跨域请求(OCR)
    @GetMapping(path = "/results", produces = "application/json")
    @ResponseBody // 请求结果查找得到 Json 文件
    public Iterable<Answer> getResJson() {

        return answerRepo.findAll();
    }

    private List<Option> filterByQuestionId(List<Option> options, int Qid) {
        return options.stream().filter(x -> x.getQuestion_id() == Qid).collect(Collectors.toList());
    }

}
