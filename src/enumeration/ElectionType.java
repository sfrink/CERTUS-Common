package enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * @date : Apr 05, 2014
 * @author : Hirosh Wickramasuriya
 */

public enum ElectionType {
	
	
	PUBLIC (1, "Public", "Public election."), 
	PRIVATE (2, "Private", "Private election.")
	;

 
    private int code;
    private String label;
    private String description;
    
    /**
     * A mapping between the integer code and its corresponding Status to facilitate lookup by code.
     */
    private static Map<Integer, ElectionType> codeToStatusMapping;
 
    private ElectionType(int code, String label, String description) {
        this.code = code;
        this.label = label;
        this.description = description;
    }
    
    public static ElectionType getStatus(int i) {
        if (codeToStatusMapping == null) {
            initMapping();
        }
        return codeToStatusMapping.get(i);
    }
 
    private static void initMapping() {
        codeToStatusMapping = new HashMap<Integer, ElectionType>();
        for (ElectionType s : values()) {
            codeToStatusMapping.put(s.code, s);
        }
    }
 
    public int getCode() {
        return code;
    }
 
    public String getLabel() {
        return label;
    }
 
    public String getDescription() {
        return description;
    }
 
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type ");
        sb.append("{code=").append(code);
        sb.append(", label='").append(label).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
 

}
