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
                              <h2>로그인 페이지</h2>
                        </div>
                        <div class="m-3">
                              <form action="/login" method="post">
                                    <div class="form-group mb-2">
                                          <input type="text" name="username" class="form-control"
                                                placeholder="Enter username" id="username">
                                    </div>
                                    <div class="form-group mb-2">
                                          <input type="password" name="password" class="form-control"
                                                placeholder="Enter password" id="password">
                                    </div>
                                    <button type="submit" class="btn btn-outline-success">로그인</button>
                              </form>
                        </div>
                        <div class="m-3">
                              <a href="/joinForm"><button class="btn btn-outline-warning">회원가입 페이지로 가기</button></a>
                        </div>
                  </div>
            </body>

            </html>