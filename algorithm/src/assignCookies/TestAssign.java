package assignCookies;

public class TestAssign {

	public static void main(String[] args) {
		int[] g = {5,2,3,1,6};
		int[] s = {1,5};
		int result = findContentChildren(g,s);
		System.out.println("");
		System.out.println(result);

	}
	
    public static int findContentChildren(int[] g, int[] s) {
        sort(g);
        for (int i = 0; i < g.length; i++)
        		System.out.print(g[i] + ",");
        sort(s);
        int result = 0, indexG = 0, indexS = 0, maxG = g.length, maxS = s.length;
        while(indexG < maxG && indexS < maxS){
            if (s[indexS] >= g[indexG]){
                indexG++;
                result++;
            }
            indexS++;
        }
        return result;
    }
    
    private static void sort(int[] data){
        //using quick sort
        recurQuickSort(data, 0, data.length - 1);
    }
    
    private static void recurQuickSort(int[] data, int start, int end){
        if (start < end){
            int pivot = data[start];
            int i = start + 1, j = end;
            while(i <= j){
                while (data[i] <= pivot && i < j)
                    i++;
                while (data[j] > pivot)
                    j--;
                if (i < j)
                		swap(data, i, j);
            }
            swap(data, start, j);
            recurQuickSort(data, start, j - 1);
            recurQuickSort(data, j + 1, end);
        }
    }
    
    private static void swap(int[] data, int index1, int index2){
        int tmp = data[index1];
        data[index1] = data[index2];
        data[index2] = tmp;
    }

}
