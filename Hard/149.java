// 149. Max Points on a Line
// https://leetcode.com/problems/max-points-on-a-line/description/

class Solution {
    int GCD(int a,int b)
    {
        if(b==0)
            return Math.abs(a);
        return GCD(b,a%b);
    }

    public int maxPoints(int[][] points) {
        int n=points.length;

        if(n<=2)
            return n;

        int duplicates=0;
        int maxcount=0; // Maximum withing the anchor point 
        int ans=0; // Global maximum
        for(int i=0;i<n-1;i++)
        {
            HashMap<String,Integer> map=new HashMap<>();
            int x1=points[i][0];
            int y1=points[i][1];

            for(int j=i+1;j<n;j++)
            {
                int x2=points[j][0];
                int y2=points[j][1];

                int dy=y2-y1;
                int dx=x2-x1; // slope= y2-y1 / x2-x1

                if(dx==0 && dy==0)
                {
                    duplicates++;
                    continue;
                }

                int gcd=GCD(dx,dy);
                dx/=gcd;
                dy/=gcd;

                // to handle negatives we make sure only numerator has negative sign
                if(dx==0)
                    dy=1;
                
                if(dy==0) // to handle cases like (1,1) and (2,1) where slope is 0/1 and 0/2
                    dx=1;
                    
                if(dx<0)
                {
                    dx=-dx;
                    dy=-dy;
                }
                String slope= dy+ "/" +dx;
                map.put(slope,map.getOrDefault(slope,0)+1);
                maxcount=Math.max(maxcount,map.get(slope));
            }
            ans=Math.max(maxcount+1+duplicates,ans);
            duplicates=0;
            maxcount=0;
        }
        return ans;
    }
}