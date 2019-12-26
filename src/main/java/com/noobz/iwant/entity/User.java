package com.noobz.iwant.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhousz
 * @date 2019/12/26 11:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  String id;
  String username;
  String password;
}
