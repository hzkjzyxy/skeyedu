/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Simple Quickstart application showing how to use Shiro's API.
 *
 * @since 0.9 RC2
 */
public class Quickstart {

   // private static final transient Logger log = LoggerFactory.getLogger(Quickstart.class);


    public static void main(String[] args) {

        // 初始化SecurityManager --shiro.ini
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

      

        // 得到当前subject
        Subject currentUser = SecurityUtils.getSubject();

        //  Session操作
        Session session = currentUser.getSession();
        session.setAttribute("someKey", "aValue");
        String value = (String) session.getAttribute("someKey");
        if (value.equals("aValue")) {
          System.out.println("Retrieved the correct value! [" + value + "]");
        }

        //未认证
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
            token.setRememberMe(true);
            try {
            	//去认证
                currentUser.login(token);
                System.out.println("--------------------认证成功");
            } catch (UnknownAccountException uae) {
              System.out.println("------>There is no user with username of " + token.getPrincipal());
            } catch (IncorrectCredentialsException ice) {
              System.out.println("--->Password for account " + token.getPrincipal() + " was incorrect!");
            } catch (LockedAccountException lae) {
              System.out.println("The account for username " + token.getPrincipal() + " is locked.  " +
                        "Please contact your administrator to unlock it.");
            }
            // ... catch more exceptions here (maybe custom ones specific to your application?
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            }
        }


      System.out.println("User [" + currentUser.getPrincipal() + "] logged in successfully.");

        //角色
        if (currentUser.hasRole("schwartz")) {
          System.out.println("May the Schwartz be with you!");
        } else {
          System.out.println("Hello, mere mortal.");
        }

        //权限
        if (currentUser.isPermitted("lightsaber:delete")) {
          System.out.println("---->You may use a lightsaber ring.  Use it wisely.");
        } else {
          System.out.println("Sorry, lightsaber rings are for schwartz masters only.");
        }

        if (currentUser.isPermitted("winnebago:drive:eagle5")) {
          System.out.println("You are permitted to 'drive' the winnebago with license plate (id) 'eagle5'.  " +
                    "Here are the keys - have fun!");
        } else {
          System.out.println("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
        }

        //登出
        System.out.println(currentUser.isAuthenticated());
        currentUser.logout();
        System.out.println(currentUser.isAuthenticated());
        
        
        System.exit(0);
    }
}
