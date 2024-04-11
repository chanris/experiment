package com.chenyue.experiment.oj;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenyue7@foxmail.com
 * @date 12/1/2024
 * @description
 */
public class lc2085 {

    public static void main(String[] args) {
        String[] s = new String[]{"bjxzvssdoq","oom","lxrrvf","aoeselhvrnw","awnornqyztqlza","bjxqkapuvaw","wibxruerngdzgjd","rezrwdzvllpbjpnikhzraz","pswmnrsepudx","nlicjldpeia","glg","nllxfcjjitmsuugmr","cl","pysmpgjakkjnusfopphb","zxlwcdjpn","xktsfnchwrdesnf","qptnoxxgrjmvr","exlfwjfsbsirbbkyqjtinrrwuhh","rqbnghajxygilgdjejopyuwyjqrx","vrjkqsicuqoalqyaxkaaogxbf","ixnlltqbpygmpjuspom","izajsxotcbhzdnkujwgdzo","b","lighabre","i","ljqqbfddipvcooh","hboedpepeeunx","bkhzhiefammwqkhvampokd","ptlozguwmyyp","loeshsjgazzwvs","kyrltbdzlymjxtvwiiq","fk","mbjpgwsahkgkehlcoqbhunqchxj","nfyuvlrmiturheb","cyqwsiysmoirurj","sciqruywy","podsrhmsozan","nlyadkrxhdbup","gdugldwghzt","wpjm","gjobdekmjisjgadkwwemnmco","dkjdtimdghvlhuetxyaklk","iwqylhdwqbwaqdouowoodhs","mn"};
        String[] s2 = new String[]{"eeormvovhzslwsqgzthlgntgzc","zfwownznh","suxrkdbjdjjtbkjucsbyk","u","y","lbjooktoctgwbbptiffytquha","dcsxrghgpultkatbecjadbespvww","vwduylshcpaiu","rtcxwctvquaiuwkgvdx","a","szearxmdqcismljmihbtkcirztdnrc","htgmuxtxdunsvfizb","hybe","nsegkgwcvopncmfpaahhhjeuqjosv","jtarnnpppxtzmopixeijqqahkd","hazcgrrnpourkyoeanodejiptne","kurhokvhixihe","ljwycewmecfqdhtxiokjn","qgjzzvpyvwetlsvcsw","aunns","nwcnfrzzvxafkfjfnczummtubikji","nipiygnvlfntgpxfedj","mgnt","xvjehufvaqouhztnmts","sjtbrfjwtqxakqktxjaljrbwfoxvz","dfeujeikfrtrpiafrgxvjlkpxtog","u","ggbcxoasodaqaazulrxjleecexey","inedrgssajhpygfvozigohis","pevxwgfzxebybfe","cgy","fnhvlx","vxfybaebkoq","xvhx","mxbqjtanctljewwjjlbpkgbtsm","mlwagamcikbcpuexhikmizp","qeiomipvsoqlsnhylulirrcwtqga","bwemqcgyusuauwlpbjjru","iimcbidtndh","lpjejlkmxtlbyvnscy","dlspriicnyykdsyvswlgktavwloq","dib","qoptbduulgqwquvhdvmwdz","xrtxghrbfrhpzduxeljnctgg","schmbsaupayqnpchn","kah","itotymryqufqpozrwmvsl","gurb","xsyocxcmwvqmnmxthfemmu","pkfdutm","hkbwxwjxyuld","ukdqszfjckdunnhpevw","kqfwytdvnvjrchiwprcqkfntqticsc","zjmsfwjddgjiypsmagdrujb","gn","ebncbjvhpbjecbrizdpv","nbfehcktwswih","sttmqcdmobdgtgkyxydyovahknjbsn","sryyufrtocf","eiicpwknxrzqylqpybhfd","pey","njimttradeoa","wcogjdfr","prva","tyxdmxgw","wluzocppg","kzm","wbyyperlkflaoxyxftzwxvmemof","snzpclbulddnmmjmpdurcybo","mowxgpmzojtmympmt","uvtnojjahrovzmlukf","sykhtgejlmbzshhneoyqr","ib","haqkkizidifykwijm","csjtexnr","yvgr","vzcxbtlthrynnawxnkxdptp","yvxrmscsckv"};
        int n = countWords(s, s2);
        System.out.println(n);
    }

    public static int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> m = new HashMap<>();
        HashMap<String, Integer> m2 = new HashMap<>();
        for(String s :words1) {
            if(!m.containsKey(s)) {
                m.put(s, 1);
            }else {
                m.put(s, 3);
            }
        }
        for(String s :words2) {
            if(!m2.containsKey(s)) {
                m2.put(s, 1);
            }else {
                m2.put(s, 3);
            }
        }
        AtomicInteger n = new AtomicInteger(0);
        m.forEach((key, value) ->{
            if(value == 1 && m2.containsKey(key) &&m2.get(key) == 1) {
                n.getAndIncrement();
            }
        });
        return n.get();
    }
}
