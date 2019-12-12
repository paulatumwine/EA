Two ways to do authentication in jpa
1) MyUserDetailService & MyUserDetail:  They're actually to teach you what UserDetailService &UserDetail used for by everything is hardcoded
2) JPAUserDetailService & JPAUserDetail: connect DB to pull user info

data.sql - has prepopulated values, using bcrypt for password encoding
1) username&password: user/123456
2) username&password: admin/hello