




public class NeteasMusicUrl {
    
    public static EncodeOfNeteas encodeOfNeteas = new EncodeOfNeteas();

    public static String getNeteasMusicUrlByName(String musicName){

        int id = NeteasMusicId.getNeteasMusicIdByName(musicName);
        String url = NeteasParams.URL_OF_PLAY;
        String dOfPlay = NeteasParams.D_OF_PLAY;
        dOfPlay = dOfPlay.replace("506092956", String.valueOf(id));
        String I = encodeOfNeteas.a(16);
        String params = encodeOfNeteas.getParams(dOfPlay, NeteasParams.G, I);
        String encSecKey = encodeOfNeteas.getEncSecKey(I, NeteasParams.E, NeteasParams.F);

        String result = Req.Post(url, params, encSecKey);

        int start = result.indexOf(",\"url\":\"");
        int end = result.indexOf("\",\"br\":");

        String urlOfTheSong = result.substring(start+8, end);

        System.out.println(urlOfTheSong);



        return urlOfTheSong;


    }


    public static void main(String[] args) {
        NeteasMusicUrl.getNeteasMusicUrlByName("so sick");
    }

}
