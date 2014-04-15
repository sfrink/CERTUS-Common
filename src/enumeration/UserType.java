package enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * @date : Apr 05, 2014
 * @author : Hirosh Wickramasuriya
 */

public enum UserType {
	
	
	ELECTORATE (0, "Electorate", "User allowed to vote for elections"), 
	AUTHORITY (1, "Election Authority", "User allowed to manage elections"),
	INVITED(2, "Invited User", "User is invited to register in the system")
	;

 
    private int code;
    private String label;
    private String description;
    
    /**
     * A mapping between the integer code and its corresponding Status to facilitate lookup by code.
     */
    private static Map<Integer, UserType> codeToStatusMapping;
 
    private UserType(int code, String label, String description) {
        this.code = code;
        this.label = label;
        this.description = description;
    }
    
    public static UserType getStatus(int i) {
        if (codeToStatusMapping == null) {
            initMapping();
        }
        return codeToStatusMapping.get(i);
    }
 
    private static void initMapping() {
        codeToStatusMapping = new HashMap<Integer, UserType>();
        for (UserType s : values()) {
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
