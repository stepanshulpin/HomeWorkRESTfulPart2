package com.shulpin.dao;

import com.shulpin.model.Buyer;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("buyerDao")
public class BuyerDaoImpl extends AbstractDao implements BuyerDao {
    public void addBuyer(Buyer buyer) {
        persist(buyer);
    }

    @SuppressWarnings("unchecked")
    public List<Buyer> findAllBuyer() {
        Criteria criteria = getSession().createCriteria(Buyer.class);
        return (List<Buyer>) criteria.list();
    }

    public void deleteBuyerById(Long id) {
        Query query = getSession().createSQLQuery("delete from Buyer where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }

    public void deleteAllBuyer() {
        Query query = getSession().createSQLQuery("delete from Buyer");
        query.executeUpdate();
    }

    public Buyer findBuyerById(Long id) {
        Criteria criteria = getSession().createCriteria(Buyer.class);
        criteria.add(Restrictions.eq("id",id));
        return (Buyer) criteria.uniqueResult();
    }
}
