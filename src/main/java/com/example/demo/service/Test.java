package com.example.demo.service;

import com.example.demo.domain.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.internal.StatefulPersistenceContext;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.hql.internal.ast.util.SessionFactoryHelper;
import org.hibernate.internal.util.collections.IdentityMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transaction;
import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.util.Map;

@Component
@Transactional
public class Test {


    @PersistenceContext
    EntityManager entityManager;

    public void detachAndMerge(long id) {
        Session session = entityManager.unwrap( Session.class );
        Post p = session.get(Post.class, id);
        entityManager.detach(p);
        p.setAuthor("CHANGED");
        entityManager.merge(p);
        System.out.println("Detached " +p.getId() + " " + p.getAuthor());
    }

    public Post getSession(long id){
        Session session = entityManager.unwrap( Session.class );
        Post p = session.get(Post.class, id);
        System.out.print(p.getTitle());
        return p;
    }

    public void detachFromContext(long id) {
        Session session = entityManager.unwrap( Session.class );
        Post p = session.get(Post.class, id);
        entityManager.detach(p);
        p.setAuthor("CHANGED");
        System.out.println("Detached " +p.getId() + " " + p.getAuthor());
    }

    public void removeFromContext(long id) {
        Session session = entityManager.unwrap( Session.class );
        Post p = session.get(Post.class, id);
        entityManager.remove(p);
        System.out.println("Detached " +p.getId() + " " + p.getAuthor());
    }

    public void insertToContext(Post post) {
        entityManager.persist(post);
        System.out.println( "Persisted " + post.getId() + " " + post.getAuthor() );

    }

    public void changeToTran(long id) {
        Session session = entityManager.unwrap( Session.class );
        Post p = session.get(Post.class, id);
        p.setAuthor("Tran");
        System.out.println("Changed " +p.getId() + " " + p.getAuthor());
    }







}
