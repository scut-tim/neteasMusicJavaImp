

public class NeteasMusicId {
    public static EncodeOfNeteas encodeOfNeteas = new EncodeOfNeteas();
    
    public static int getNeteasMusicIdByName(String musicName){

        String dOfId = NeteasParams.D_OF_ID;
        dOfId =  dOfId.replace("chaos chaos", musicName);
        
        String I = encodeOfNeteas.a(16);
        String params = encodeOfNeteas.getParams(dOfId, NeteasParams.G, I);
        String encSecKey = encodeOfNeteas.getEncSecKey(I, NeteasParams.E, NeteasParams.F);
        String result = Req.Post(NeteasParams.URL_OF_ID, params, encSecKey);
        int start = result.indexOf(",\"id\":") + 6;
        int end = result.indexOf(",\"pst\"");
        String idStr = result.substring(start, end);
        System.out.println("just the first song for the name you gave......");
        int id = Integer.valueOf(idStr);

        return id;
    }

    public static void main(String[] args) {
        int id = NeteasMusicId.getNeteasMusicIdByName("so sick");
        System.out.println(id); 
    }

    
}


