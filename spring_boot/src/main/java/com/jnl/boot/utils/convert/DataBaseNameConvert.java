package com.jnl.boot.utils.convert;

public class DataBaseNameConvert {
    private static byte[] speceils = new byte[]{'_'};

    public static String convert(String oriString){
        byte[] cache = oriString.getBytes();
        byte[] target = new byte[cache.length];
        int targetIndex = 0;
        for(int i = 0;i<cache.length;i++){
            if(isNeedToChange(cache[i])&& i<cache.length-2){
                cache[i+1] =  new String(new byte[]{cache[i+1]}).toUpperCase().getBytes()[0];
            }else{
                target[targetIndex] = cache[i];
                targetIndex++;
            }
        }
        return new String(target,0,targetIndex);
    }

    private static boolean isNeedToChange(byte b){
        boolean need = false;
        for(byte speceil:speceils){
            if(speceil == b){
                need = true;
                break;
            }
        }
        return need;
    }

    public  static  void main(String[] args){
       System.out.println(convert("check_order"));

    }
}
