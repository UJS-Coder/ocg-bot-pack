package com.card.cardget.dao;

import com.card.cardget.dataobject.Card;
import com.card.cardget.dataobject.CardData;
import com.card.cardget.dataobject.CardText;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CardDAO {
    CardText searchById(@Param("id")int id);

    Card searchYgocardById(@Param("id")int id);

    CardData searchDataByCardId(@Param("cardId")int cardId);

    Integer getSameName(@Param("name")String name);

    Integer getcount();

    int insertData(Card card);

    int insertFront (Card card);

    Card searchNew(@Param("id")int id);

    CardText getNewId(@Param("name")String name);

    int cardIdupdate(@Param("cardId")int cardId,@Param("name")String name);

    int cardAttributeUpdate(@Param("attribute")String attribute,@Param("cardId")int cardId);
}
