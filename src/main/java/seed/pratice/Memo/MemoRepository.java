package seed.pratice.Memo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public List<Memo> findByAll() {
        return new ArrayList<>(MemoMap.values());
    }

    public void delete(Long id, String password) {
        if(MemoMap.get(id).password.equals(password)) {
            MemoMap.remove(id);
        }
    }

    public void update(Memo memo) {
        Memo memoA = MemoMap.get(memo.id);
        if (memoA.getPassword().equals(memo.password)) {
            memoA.content = memo.content;
        }
    }
}
