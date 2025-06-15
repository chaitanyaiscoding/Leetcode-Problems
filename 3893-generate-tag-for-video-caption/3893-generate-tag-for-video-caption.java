class Solution {
    public String generateTag(String caption) {
        StringBuilder sb=new StringBuilder("#");
        int y=caption.charAt(0);
        if(y>=65 && y<=90){
            y=y+32;
        }
        if(caption.charAt(0)!=' ')
        sb.append((char)y);
        System.out.println(sb);
        int first=0;
        int i=1;
        while(sb.length()<100 && i<caption.length())
        {
            if(first==0){
                if((caption.charAt(i)>=65 && caption.charAt(i)<=90) ||(caption.charAt(i)>=97 && caption.charAt(i)<=122))
                {
                    int e=caption.charAt(i);
                    if(e>=65 && e<=90){
                        e=e+32;
                    }
                    sb.append((char)e);
                }
            }
            else
            {
                int x=caption.charAt(i);
                if(x>=97 && x<=122){
                    x=x-32;
                }
                if(caption.charAt(i)!=' ')
                sb.append((char)x);

            }
            if(caption.charAt(i)==' ')
            first=1;
            else first =0;
            i++;
        }
        return sb.toString();
    }
}