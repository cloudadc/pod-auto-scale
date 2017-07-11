/*
 * JBoss, Home of Professional Open Source
 * Copyright 2017, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openshift.labs;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/send")
public class PodAutoScaleServlet extends HttpServlet {

    private static final long serialVersionUID = -4904213485032500559L;

    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        System.out.println("[" + sdf.format(new Date()) + "] - " + Thread.currentThread().getName() + " start");
        
        String term = System.getProperty("CPU_OCCUPATION_TIME", "5");
        int mins = Integer.parseInt(term);
        long millis = mins * 60 * 1000;
        long start = System.currentTimeMillis();
        long cur = -1;
        while(cur < 0) {
            cur = (System.currentTimeMillis() - start) - millis ;
        }
        
        System.out.println("[" + sdf.format(new Date()) + "] - " + Thread.currentThread().getName() + " end");
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    
}
