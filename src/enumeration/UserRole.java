package enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * @date : Apr 05, 2014
 * @author : Hirosh Wickramasuriya
 */

public enum UserRole {
	
	
	ELECTORATE (0, "Electorate", "User allowed to vote for elections"), 
	AUTHORITY (1, "Election Authority", "User allowed to manage elections")
	;

 
    private int code;
    private String label;
    private String description;
    
    /**
     * A mapping between the integer code and its corresponding Status to facilitate lookup by code.
     */
    private static Map<Integer, UserRole> codeToStatusMapping;
 
    private UserRole(int code, String label, String description) {
        this.code = code;
        this.label = label;
        this.description = description;
    }
    
    public static UserRole getStatus(int i) {
        if (codeToStatusMapping == null) {
            initMapping();
        }
        return codeToStatusMapping.get(i);
    }
 
    private static void initMapping() {
        codeToStatusMapping = new HashMap<Integer, UserRole>();
        for (UserRole s : values()) {
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