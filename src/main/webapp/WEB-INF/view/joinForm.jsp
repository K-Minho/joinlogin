<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
                  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
                  <title>Document</title>
            </head>

            <body>
                  <div class="container">
                        <div class="text-center m-3">
                              <h2>회원가입 페이지</h2>
                        </div>
                        <form action="/join" method="post">
                              <div class="form-group mb-2">
                                    <input type="text" name="username" placeholder="Enter username" class="form-control"
                                          id="username">
                              </div>

                              <div class="form-group mb-2">
                                    <input type="password" name="password" class="form-control"
                                          placeholder="Enter password" class="form-control" id="password">
                              </div>

                              <div class="form-group mb-2">
                                    <input type="password" placeholder="Enter passwordCheck" class="form-control"
                                          id="passwordCheck">
                              </div>

                              <div class="form-group mb-2">
                                    <input type="email" name="email" placeholder="Enter email" class="form-control"
                                          id="email">
                              </div>

                              <button type="submit" class="btn btn-outline-success">회원가입</button>
                        </form>
                        <div class="my-3">
                              <a href="/loginForm"><button class="btn btn-outline-warning">로그인 페이지로 가기</button></a>
                        </div>
                  </div>
            </body>

            </html>