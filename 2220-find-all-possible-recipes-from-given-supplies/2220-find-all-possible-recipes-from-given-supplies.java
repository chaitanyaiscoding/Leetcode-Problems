class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> initial=new HashSet<>();
        for(String str:supplies)
            initial.add(str);

        List<String> ls=new ArrayList<>();
        int count=recipes.length;
        while(count-->0)
        {
            for(int i=0;i<recipes.length;i++)
            {
                if(ls.contains(recipes[i]))
                    continue;
                boolean allAvail=true;
                for(int j=0;j<ingredients.get(i).size();j++)
                {
                    if(!initial.contains(ingredients.get(i).get(j)))
                    {
                        allAvail=false;
                        break;
                    }
                }
                if(allAvail)
                {
                    initial.add(recipes[i]);
                    ls.add(recipes[i]);
                }
            }
        }    
        return ls;
    }
}