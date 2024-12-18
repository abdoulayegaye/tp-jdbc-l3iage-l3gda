package service;

import config.Db;
import entity.User;

import java.sql.ResultSet;
import java.util.List;

public class UserServiceImpl implements IUserService{
    private Db db = new Db();
    private ResultSet rs;
    private int ok;
    @Override
    public int create(User user) {
        String sql = "INSERT INTO user VALUES(NULL, ?, ?, ?, ?)";
        try{
            //Ouverture de la connexion
            db.initPrepar(sql);
            //Passage de valeurs
            db.getPstm().setString(1, user.getFirstname());
            db.getPstm().setString(2, user.getLastname());
            db.getPstm().setString(3, user.getUsername());
            db.getPstm().setString(4, user.getPassword());
            //Exécution de la requete
            ok = db.executeMaj();
            //Fermeture de la connexion
            db.closeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
