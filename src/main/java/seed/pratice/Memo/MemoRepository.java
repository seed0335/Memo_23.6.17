package seed.pratice.Memo;

import java.util.HashMap;
import java.util.Map;

public class MemoRepository {
    public static final Map<Long, Memo> MemoMap = new HashMap<>();
    private static long sequence = 0L;

    public Memo save(Memo memo){
        memo.setId(++sequence);
        MemoMap.put(memo.getId(), memo);
        return memo;
    }

    //id로 memo 를 찾기 기능
    public Memo findById(Long id){
        return MemoMap.get(id);
    }
}
