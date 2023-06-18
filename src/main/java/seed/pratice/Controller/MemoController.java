package seed.pratice.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import seed.pratice.Memo.Memo;
import seed.pratice.Memo.MemoRepository;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/memos")
public class MemoController {

    private MemoRepository memoRepository = new MemoRepository();

    // 전체 조회
    @GetMapping
    public String memos(Model model) {
        if(memoRepository.findByAll().size() == 0) {
            Memo memo = new Memo("kim", "1234", "hard");
            memoRepository.save(memo);
        }

        List<Memo> allMemoList = memoRepository.findByAll();
        model.addAttribute("allMemoList",allMemoList);
        return "memos";
    }

    @GetMapping("/memos")
    public String memos2(Model model) {
        List<Memo> allMemoList = memoRepository.findByAll();
        model.addAttribute("allMemoList",allMemoList);
        return "memos";
    }

    // 개별 조회 (검색 기능)
    @GetMapping("/search")
    public String search(@RequestParam Long id, Model model){
        Memo searchMemo = memoRepository.findById(id);
        model.addAttribute("searchMemo", searchMemo);
        return "searchMemo";
    }

    // 저장 기능
    @PostMapping
    public String save(@ModelAttribute("memo") Memo memo, Model model) {
        memoRepository.save(memo);
        model.addAttribute("memo",memo);
        return "redirect:memos";
    }

    // 삭제 기능
    @PostMapping("/delete")
    public String delete(@RequestParam Long id, @RequestParam String password){
        memoRepository.delete(id, password);
        return "redirect:memos";
    }

    // 업데이트 form 없이, 포스트맨 사용
    @PatchMapping
    public String update(@RequestBody Memo memo){
        log.info(memo.password);
        memoRepository.update(memo);
        return "memos";
    }
}
