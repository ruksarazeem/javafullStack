var express = require('express')
var jwt = require('jsonwebtoken')
var app=express()
app.get(
    '/api' ,(req,res)=>{
        res.join({
            message:"welcome to API"
        })
})
app.post('/api/posts',verifyToken,(req,res)=>{
    jwt.verify(req.token,'secretkey',(err,authData)=>{
        if(err){
            res.sendstatus(403)
        }
        else{
            res.json({
                message:"post created...",
                authData
            })
        }
    })
})
app.post('/api/login',(req,res)=>{
    const user={
        id:1144,
        name:"ruks",
        email:"xxxxxx23@gmail.com"
    }
    jwt.sign({user},'secretkey',{expressIn:'305'},
    (err,token)=>{
        res.join({
            token
        })
    })
})
function verifyToken(req,res,next){
    const bearerleader=req.header['authorization']
    if(typeof bearerleader!=='undefined'){
        const bearer=bearerleader.split('');
        const bearerToken=bearer[1];
        req.token=bearerToken;
        next()

    }
    else{
        res.sendstatus(403)
    }
}
app.listen(1245,()=>console.log("serverStarted"));
