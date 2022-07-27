package com.card.cardget.util;

import java.util.ArrayList;
import java.util.List;

public class CardUtil {
    public static String getzz(byte[] bArray){
        String zzstr=HexUtil.HextoString(HexUtil.bytesToHexString(bArray));
        String zz="";
        switch (zzstr){
            case "1":
                zz="战士族";
                break;
            case "2":
                zz="魔法师族";
                break;
            case "4":
                zz="天使族";
                break;
            case "8":
                zz="恶魔族";
                break;
            case "10":
                zz="不死族";
                break;
            case "20":
                zz="机械族";
                break;
            case "40":
                zz="水族";
                break;
            case "80":
                zz="炎族";
                break;
            case "100":
                zz="岩石族";
                break;
            case "200":
                zz="鸟兽族";
                break;
            case "400":
                zz="植物族";
                break;
            case "800":
                zz="昆虫族";
                break;
            case "1000":
                zz="雷族";
                break;
            case "2000":
                zz="龙族";
                break;
            case "4000":
                zz="兽族";
                break;
            case "8000":
                zz="兽战士族";
                break;
            case "10000":
                zz="恐龙族";
                break;
            case "20000":
                zz="鱼族";
                break;
            case "40000":
                zz="海龙族";
                break;
            case "80000":
                zz="爬虫类族";
                break;
            case "100000":
                zz="念动力族";
                break;
            case "200000":
                zz="幻神兽族";
                break;
            case "400000":
                zz="创造神族";
                break;
            case "800000":
                zz="幻龙族";
                break;
            case "1000000":
                zz="电子界族";
                break;
            default :

        }
        return zz;
    }
    public static List<String> getType(byte[] bArray){
        List<String> types=new ArrayList<>();
        //前去头部可能存在的0
        String str=HexUtil.HextoString(HexUtil.bytesToHexString(bArray));
        int n=str.length();
        switch (str.charAt(n-1)){
            case '1':
                types.add("怪兽");
                break;
            case '2':
                types.add("魔法");
                break;
            case '4':
                types.add("陷阱");
                break;
            case '8':
                types.add("N/A");
                break;
            default:
        }
        if (n>=2&&str.charAt(n-2)!='0'){
            switch (str.charAt(n-2)){
                case '1':
                    types.add("通常");
                    break;
                case '2':
                    types.add("效果");
                    break;
                case '4':
                    types.add("融合");
                    break;
                case '6':
                    types.add("效果");
                    types.add("融合");
                    break;
                case '8':
                    types.add("仪式");
                    break;
                case 'A':
                    types.add("效果");
                    types.add("仪式");
                    break;
                default:
            }
        }
        if (n>=3&&str.charAt(n-3)!='0'){
            switch (str.charAt(n-3)){
                case '1':
                    types.add("N/A");
                    break;
                case '2':
                    types.add("灵魂");
                    break;
                case '4':
                    types.add("同盟");
                    break;
                case '8':
                    types.add("二重");
                    break;
                default:
            }
        }
        if (n>=4&&str.charAt(n-4)!='0'){
            switch (str.charAt(n-4)){
                case '1':
                    types.add("调整");
                    break;
                case '2':
                    types.add("同调");
                    break;
                case '3':
                    types.add("调整");
                    types.add("同调");
                    break;
                case '4':
                    types.add("衍生物");
                    break;
                case '5':
                    types.add("调整");
                    types.add("衍生物");
                    break;
                case '8':
                    types.add("N/A");
                    break;
                default:
            }
        }
        if (n>=5&&str.charAt(n-5)!='0'){
            switch (str.charAt(n-5)){
                case '1':
                    types.add("速攻");
                    break;
                case '2':
                    types.add("永续");
                    break;
                case '4':
                    types.add("装备");
                    break;
                case '8':
                    types.add("场地");
                    break;
                default:
            }
        }
        if (n>=6&&str.charAt(n-6)!='0'){
            switch (str.charAt(n-6)){
                case '1':
                    types.add("反击");
                    break;
                case '2':
                    types.add("反转");
                    break;
                case '4':
                    types.add("卡通");
                    break;
                case '8':
                    types.add("超量");
                    break;
                default:
            }
        }
        if (n>=7&&str.charAt(n-7)!='0'){
            switch (str.charAt(n-7)){
                case '1':
                    types.add("灵摆");
                    break;
                case '2':
                    types.add("特殊召唤");
                    break;
                case '3':
                    types.add("灵摆");
                    types.add("特殊召唤");
                    break;
                case '4':
                    types.add("连接");
                    break;
                default:
            }
        }
        return types;
    }
    public static String getLevel(byte[] bArray){
        String bstr=HexUtil.HextoString(HexUtil.bytesToHexString(bArray));
        String level="";
        switch (bstr.charAt(bstr.length()-1)+""){
            case "1":
                level="1";
                break;
            case "2":
                level="2";
                break;
            case "3":
                level="3";
                break;
            case "4":
                level="4";
                break;
            case "5":
                level="5";
                break;
            case "6":
                level="6";
                break;
            case "7":
                level="7";
                break;
            case "8":
                level="8";
                break;
            case "9":
                level="9";
                break;
            case "A":
                level="10";
                break;
            case "B":
                level="11";
                break;
            case "C":
                level="12";
                break;
            case "D":
                level="13";
                break;
            default :
        }
        return level;
    }
    public static String getAttribute(byte[] bArray){
        String atstr=HexUtil.HextoString(HexUtil.bytesToHexString(bArray));
        String attribute="";
        switch (atstr){
            case "1":
                attribute="地";
                break;
            case "2":
                attribute="水";
                break;
            case "4":
                attribute="炎";
                break;
            case "8":
                attribute="风";
                break;
            case "10":
                attribute="光";
                break;
            case "20":
                attribute="暗";
                break;
            case "40":
                attribute="神";
                break;
            default :
        }
        return attribute;
    }
}
