package problems;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

class LargestSubArrayWithEqual01 {
    
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
        
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
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
    
    public static long solve(int[] arr) {
		
		long maxLen = 0;
		long sum = 0;
		
		Map<Long, Long> map = new HashMap<>();
		for(int i=0 ; i<arr.length ; i++) {
			
			sum += (arr[i] == 1) ? 1 : -1;
			
			if(sum == 0) {
				maxLen = i + 1;
			}
			if(map.containsKey(sum)) {
				if(maxLen < i - map.get(sum)) {
					maxLen = i - map.get(sum);
				}
			} else {
				map.put(sum, (long)i);
			}
		}
		
		return maxLen;
	}
	
    public static void main(String args[] ) throws Exception {
        
        FastReader fr = new FastReader();
        
        int n = fr.nextInt();
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++) 
            arr[i] = fr.nextInt();
        
        System.out.println(solve(arr));
    }
}

