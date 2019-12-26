package com.noobz.iwant.dao;

import com.dareway.framework.dbengine.DE;
import com.dareway.framework.exception.AppException;
import com.dareway.framework.util.DataObject;
import com.dareway.framework.util.DataStore;
import com.noobz.iwant.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author zhousz
 * @date 2019/12/26 11:20
 */
@Repository
public class UserDao {

  /**
   * 根据用户名获取用户信息
   *
   * @param username
   * @author zhousz
   * @date 2019/12/26  11:28
   * @return com.dareway.framework.util.DataObject
   * @throws
   */
  public DataObject getUserByUsername(String username) throws AppException {
    DE de = DE.getInstance();
    de.clearSql();
    de.addSql("select id, username, password ");
    de.addSql("  from iwant.user ");
    de.addSql(" where username = :username ");
    de.setString("username", username);
    DataStore vds = de.query();
    return vds.rowCount() > 0 ? vds.getRow(0) : null;
  }
}
