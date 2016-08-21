package site.nebulas.dao;

import java.util.List;
import java.util.Map;

public interface RankDao {
	public List<Map<String,String>> getExercisesRank();
	public List<Map<String,String>> getIntegralRank();
}
