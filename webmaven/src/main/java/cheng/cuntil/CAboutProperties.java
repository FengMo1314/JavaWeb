package cheng.cuntil;

import java.util.List;

public class CAboutProperties {
    private final String path = "D:\\MyProgrammingLanguagesWorkspace\\JavaWeb\\webmaven\\src\\main\\resources";
    private List<String> Properties_Paths;
    private String Properties_Path;

    public CAboutProperties(int index) {
        PropertiesPaths ptps = new PropertiesPaths();
        this.setProperties_Path(ptps.getFileAbsolutePath(path, 1).get(index));
    }

    public static void main(String[] args) {
        CAboutProperties pt = new CAboutProperties(2);
        System.out.println(pt.getProperties_Path());
    }

    public String getProperties_Path() {
        return Properties_Path;
    }

    public void setProperties_Path(String properties_Path) {
        Properties_Path = properties_Path;
    }

}
