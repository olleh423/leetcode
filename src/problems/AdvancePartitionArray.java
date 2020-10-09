package problems;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AdvancePartitionArray {

	//DP implementation
	public static int part(int[] a, int n, int k, int res[][]) {
        
        if(k == 1) return getStrength(a, 0, n);
        
        if(res[k-1][n-1] != 0) return res[k-1][n-1];
        
        int max = Integer.MIN_VALUE;
        for(int i = n-1 ; i > 0 ; i--) {
            max = Integer.max(max, getStrength(a, i, n) + part(a, i, k-1, res));
        }
        res[k-1][n-1] = max;
        return max;
    }
	
	private static int getStrength(int[] arr, int start, int end) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=start ; i<end ; i++) {
			if(map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i]) + 1);
			else map.put(arr[i], 1);
		}
		int max = 0;
		for(Integer key : map.keySet()) {
			if(map.get(key) % 2 != 0 && key > max) {
				max = key;
			}
		}
		return max;
	}
	
	public static int part(int[] arr, int K) {
		
		return part(arr, arr.length, K, new int[K][arr.length]);
	}
	
	public static void main(String[] args) {
		
		try {
			FastReader fr = new FastReader();
			int test = fr.nextInt();
			while(test > 0) {
				
				int n = fr.nextInt();
				int k = fr.nextInt();
				
				int[] arr = new int[n];
				for(int i=0 ; i<n ; i++) 
					arr[i] = fr.nextInt();
				
				for(int i=1 ; i<=k ; i++)
					System.out.print(part(arr, i) + " ");
				System.out.println();
				
				test--;
			}
		} catch(Exception e) {
			return;
		}
	}
	
	static class FastReader
	{
		final private int BUFFER_SIZE = 1 << 16;
	    private DataInputStream din;
	    private byte[] buffer;
	    private int bufferPointer, bytesRead;
	 
	    public FastReader()
	    {
	    	din = new DataInputStream(System.in);
	        buffer = new byte[BUFFER_SIZE];
	        bufferPointer = bytesRead = 0;
	    }
	    
	    public FastReader(String file_name) throws IOException
	    {
	    	din = new DataInputStream(new FileInputStream(file_name));
	        buffer = new byte[BUFFER_SIZE];
	        bufferPointer = bytesRead = 0;
		}
	    
	    private void fillBuffer() throws IOException
	    {
	        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
	        if (bytesRead == -1)
	            buffer[0] = -1;
	    }

	    private byte read() throws IOException
	    {
	        if (bufferPointer == bytesRead)
	            fillBuffer();
	        return buffer[bufferPointer++];
	    }

	    public void close() throws IOException
	    {
	        if (din == null)
	            return;
	        din.close();
	    }
	 
	    public String readLine() throws IOException
	    {
	    	byte[] buf = new byte[64]; // line length
	        int cnt = 0, c;
	        while ((c = read()) != -1)
	        {
	        	if (c == '\n')
	        		break;
	            buf[cnt++] = (byte) c;
	        }
	        return new String(buf, 0, cnt);
		}
	 
	    public int nextInt() throws IOException
	    {
	    	int ret = 0;
	        byte c = read();
	        while (c <= ' ')
	        c = read();
	        boolean neg = (c == '-');
	        if (neg)
	        c = read();
	        do
	        {
	        	ret = ret * 10 + c - '0';
	        }  while ((c = read()) >= '0' && c <= '9');
	 
	        if (neg)
	        	return -ret;
	        return ret;
	    }
	}
}
