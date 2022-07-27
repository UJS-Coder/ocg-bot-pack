package com.card.cardget.controller;

import com.card.cardget.dao.CardDAO;
import com.card.cardget.dataobject.Card;
import com.card.cardget.dataobject.CardData;
import com.card.cardget.dataobject.CardText;
import com.card.cardget.util.CardUtil;
import com.card.cardget.util.HexUtil;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CardController {
    @Autowired
    CardDAO cardDAO;

    //正式卡表更新(和先行卡表共用datas和texts)
    @GetMapping("cardstartOfficial")
    @ResponseBody
    public int cardstartOfficial(){
        int re=0;
        int num=cardDAO.getcount();
        for (int i=0;i<=num;i++) {
                Card card = new Card();
                CardText cardText = cardDAO.searchById(i);
                if (cardText != null) {
                    if (cardDAO.getSameName(cardText.getName()) == 0) {
                        CardData cardData = cardDAO.searchDataByCardId(cardText.getCardId());
                        if (cardData != null) {
                            card.setCardId(cardText.getCardId());
                            card.setName(cardText.getName());
                            card.setEffect(cardText.getEffect());
                            List<String> types = CardUtil.getType(cardData.getType());
                            card.setMainType(types.get(0));
                            card.setType(StringUtils.join(types, ' '));
                            if (types.get(0) == "怪兽") {
                                card.setAtk(cardData.getAtk());
                                card.setZz(CardUtil.getzz(cardData.getZz()));
                                card.setAttribute(CardUtil.getAttribute(cardData.getAttribute()));
                                if (!types.contains("连接")) {
                                    card.setDef(cardData.getDef());
                                }
                                if (types.contains("超量")) {
                                    card.setLevel(CardUtil.getLevel(cardData.getLevel()) + " 阶");
                                } else if (types.contains("连接")) {
                                    card.setLevel("Link " + CardUtil.getLevel(cardData.getLevel()));
                                } else {
                                    card.setLevel(CardUtil.getLevel(cardData.getLevel()) + " 星");
                                }
                            }
                            cardDAO.insertData(card);
                            System.out.println("完成" + i + "/" + num);
                            re++;
                        }
                    }
                }
        }
        return re;
    }

    //先行卡表更新
    @GetMapping("cardstartFront")
    @ResponseBody
    public int cardstartFront(){
        int re=0;
        int num=cardDAO.getcount();
        for (int i=1;i<num;i++) {
            Card card = new Card();
            CardText cardText = cardDAO.searchById(i);
            if (cardText != null) {
                if (cardDAO.getSameName(cardText.getName()) == 0) {
                    CardData cardData = cardDAO.searchDataByCardId(cardText.getCardId());
                    if (cardData != null) {
                        card.setCardId(cardText.getCardId());
                        card.setName(cardText.getName());
                        card.setEffect(cardText.getEffect());
                        List<String> types = CardUtil.getType(cardData.getType());
                        card.setMainType(types.get(0));
                        card.setType(StringUtils.join(types, ' '));
                        if (types.get(0) == "怪兽") {
                            card.setAtk(cardData.getAtk());
                            card.setZz(CardUtil.getzz(cardData.getZz()));
                            card.setAttribute(CardUtil.getAttribute(cardData.getAttribute()));
                            if (!types.contains("连接")) {
                                card.setDef(cardData.getDef());
                            }
                            if (types.contains("超量")) {
                                card.setLevel(CardUtil.getLevel(cardData.getLevel()) + " 阶");
                            } else if (types.contains("连接")) {
                                card.setLevel("Link " + CardUtil.getLevel(cardData.getLevel()));
                            } else {
                                card.setLevel(CardUtil.getLevel(cardData.getLevel()) + " 星");
                            }
                        }
                        cardDAO.insertFront(card);
                        System.out.println("完成" + i + "/" + num);
                        re++;
                    }
                }
            }
        }
        return re;
    }

    @GetMapping("cardupdate")
    @ResponseBody
    public void cardupdate(){
        for(int i=11;i<103;i++){
            Card card=cardDAO.searchNew(i+1);
            String name=card.getName();
            CardText cardtext=cardDAO.getNewId(name);
            if(cardtext!=null){
                int cardId=cardtext.getCardId();
                int re=cardDAO.cardIdupdate(cardId,name);
                if(re==1){
                    System.out.println("完成"+i+"/103");
                }
            }
        }
    }

    @GetMapping("cardattributeUpdate")
    @ResponseBody
    public void cardattributeUpdate(){
        for(int i=11789;i<11861;i++){
            Card card=cardDAO.searchYgocardById(i+1);
//            String name=card.getName();
            CardData cardData=cardDAO.searchDataByCardId(card.getCardId());
            String attribute=CardUtil.getAttribute(cardData.getAttribute());
            cardDAO.cardAttributeUpdate(attribute,card.getCardId());
            System.out.println("已经完成"+(i+1)+"/11861");
        }
    }
}
