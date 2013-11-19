package lis.tictactoe.model.ai;

public enum EAI {
	LOOKUP,
	RULE_BASED;
	
	public String toString() {
		String result = "";
		if (equals(LOOKUP)) {
			result = "LookupAI";
		} else
		if (equals(RULE_BASED)) {
			result = "RulesBasedAI";
		}
		return result;
	}
}
