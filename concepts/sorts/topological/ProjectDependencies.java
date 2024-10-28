import java.util.*;

class ProjectDependencies {

    HashMap<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();

    public static void main(String[] args) {
        char[] projects = {'a','b','c','d','e','f'};
        char[][] dependencies = {{'d','a'},{'b','f'},{'d','b'},{'a','f'},{'c','d'}};
        ProjectDependencies pd = new ProjectDependencies();
        String order = pd.findProjectDependencyOrder(projects, dependencies);
        System.out.println("order = " + order);
    }

    public String findProjectDependencyOrder(char[] projects, char[][] dependencies) {
        //Build the adjacency map 
        for(int i = 0; i < dependencies.length; i++) {
            String project = String.valueOf(dependencies[i][0]);
            String dependency = String.valueOf(dependencies[i][1]);
            ArrayList<String> depList = hm.getOrDefault(project, new ArrayList<String>());
            depList.add(dependency);
            hm.put(project, depList);
        }

        ArrayList<String> visited = new ArrayList<String>();
        ArrayList<String> order = new ArrayList<String>();
        for(int i = 0; i < projects.length; i++) {
            order = searchForDependencyAndReturnOrder(String.valueOf(projects[i]), visited, order);
        }

        return String.join(" ", order);
    }
    public ArrayList<String> searchForDependencyAndReturnOrder(String project, ArrayList<String> visited, ArrayList<String> order) {
        if(visited.contains(project)) {
            return order;
        }
        for (HashMap.Entry<String, ArrayList<String>> entry : hm.entrySet()) {
            if(entry.getKey().equalsIgnoreCase(project)) {
                for (String dep : entry.getValue()) {
                    order = searchForDependencyAndReturnOrder(dep, visited, order);
                }
            }
        }
        visited.add(project);
        order.add(project);

        return order;
    }
}