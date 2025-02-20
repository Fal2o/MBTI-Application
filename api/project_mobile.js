var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var mysql = require('mysql');
var bcrypt = require('bcrypt')
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
  extended: true
}));

app.get('/', function(req, res) {
  return res.send({ error: true, message: 'Test Project Mobile API' });
});

var dbConn = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: '',
  database: 'pls_dont_red'
});

dbConn.connect();

app.get('/allQuestion', function(req,res){
    dbConn.query('SELECT * FROM Question', function(error, results, fields){
        if(error) throw error;
        return res.send(results);
    });
});

app.get('/allAnswer', function(req,res){
    dbConn.query('SELECT * FROM Answer', function(error, results, fields){
        if(error) throw error;
        return res.send(results);
    });
});

app.get('/allmbti_all', function(req,res){
    dbConn.query('SELECT * FROM mbti', function(error, results, fields){
        if(error) throw error;
        return res.send(results);
    });
});

// app.get('/allmbti/:mbti_char', function(req,res){
//     let mbti_char = req.params.mbti_char;

//     dbConn.query('SELECT * FROM mbti WHERE mbti_char = ?',[mbti_char], function(error, results, fields){
//         if(error) throw error;
//         return res.send(results[0]);
//     });
// });

app.get('/allmbtit', function(req, res) {
    let mbti_char = req.query.mbti_char;

    if (mbti_char && mbti_char.length > 0 && mbti_char.length <= 4) {
        dbConn.query('SELECT * FROM mbti WHERE mbti_char LIKE ?', [mbti_char + '%'], function(error, results, fields) {
            if (error) throw error;
            return res.send(results);
        });
    } else {
        dbConn.query('SELECT * FROM mbti', function(error, results, fields) {
            if (error) throw error;
            return res.send(results);
        });
    }
});



app.get('/allResgiter', function(req, res) {
    dbConn.query('SELECT * FROM register_user', function(error, results, fields){ 
        if (error) throw error;
        return res.send(results);
    });
  });

  app.get('/allPost', function(req, res) {
    dbConn.query('SELECT post.*, register_user.profile ,register_user.usr_name FROM post JOIN register_user ON post.usr_id = register_user.usr_id WHERE post.del_status = "N"', function(error, results, fields){ 
        if (error) throw error;
        return res.send(results);
    });
});


  
  app.get('/login/:usr_id/:usr_password', async function (req, res) {
    let usr_id = req.params.usr_id;
    let password = req.params.usr_password;
    if (!usr_id || !password) {
        return res.status(400).send({ error: user, message: 'Please provide User id and password.' });
    }
    dbConn.query('SELECT * FROM register_user WHERE usr_id = ? ', [usr_id], function(error, results, fields) {
        if(error) throw error;
        if (results[0]) {
            bcrypt.compare(password, results[0].usr_password, function(error, result) {
                if (error) throw error;
                if (result) {
                    return res.send({"success":1, "usr_id": results[0].usr_id, "usr_name":results[0].usr_name, "usr_mbti":results[0].usr_mbti, "usr_gender":results[0].usr_gender, "role":results[0].role});
                } else {
                    return res.send({"success": 0 });
                }
            });
        } else {
            return res.send({"success":0});
        }
    });
  });
  
  app.get('/search/:id', function (req, res) {
    let usr_id = req.params.id;
    if (!usr_id) {
        return res.status(400).send({ error: true, message: 'Please provide user id' });
    }
    dbConn.query('SELECT * FROM register_user WHERE usr_id = ?', usr_id, function (error, results, fields) { 
        if (error) throw error;
        if (results[0]) {
            return res.send({"usr_id": results[0].usr_id, "usr_name":results[0].usr_name, "usr_mbti":results[0].usr_mbti, "usr_gender":results[0].usr_gender, "role": results[0].role, "profile": results[0].profile});
        } else {
            return res.status(400).send({ error: true, message: 'User id Not Found!!' });
        }
    });
  });


  app.post('/insertUserMbti', async function (req, res) {
    let post = req.body;
    let user_id = post.user_id;
    let mbti_id = post.mbti_id;

    if (!post) {
        return res.status(400).send({ error: true, message: 'Please provide user and MBTI data' });
    }


    // ตรวจสอบว่ามีผู้ใช้นี้ในฐานข้อมูลหรือไม่
    dbConn.query('SELECT * FROM user_hasmany_mbti WHERE user_id = ?', [user_id], function (error, results, fields) {
        if (error) throw error;
        if (results[0]) {
            // ตรวจสอบว่า mbti_id ของ usr_id นี้มีค่าเดียวหรือไม่
            dbConn.query('SELECT * FROM user_hasmany_mbti WHERE user_id = ? AND mbti_id = ?', [user_id, mbti_id], function (error, results, fields) {
                if (error) throw error;
                if (results[0]) {
                    return res.status(400).send({ error: true, message: 'This user already has the specified MBTI ID.' });
                } else {
                    // เพิ่มข้อมูลผู้ใช้พร้อม MBTI ID ลงในฐานข้อมูล
                    dbConn.query('INSERT INTO user_hasmany_mbti (user_id, mbti_id) VALUES (?, ?)', [user_id, mbti_id], (error, results) => {
                        if (error) throw error;
                        return res.send(results);
                    });
                }
            });
        } else {
            // เพิ่มข้อมูลผู้ใช้พร้อม MBTI ID ลงในฐานข้อมูล
            dbConn.query('INSERT INTO user_hasmany_mbti (user_id, mbti_id) VALUES (?, ?)', [user_id, mbti_id], (error, results) => {
                if (error) throw error;
                return res.send(results);
            });
        }
    });

});

app.get('/getUserMbti/:user_id', function(req, res) {
    // รับ user_id ที่ส่งมาในคำขอ
    const user_id = req.params.user_id;
    if (!user_id) {
        return res.status(400).send({ error: true, message: 'Please provide user id' });
    }
    // สร้างคำสั่ง SQL SELECT เพื่อดึงข้อมูล mbti_id ของ user_id จากฐานข้อมูล
    const sql = 'SELECT mbti_id FROM user_hasmany_mbti WHERE user_id = ? AND del_status ="N" ';
    // ดำเนินการคิวรีข้อมูลในฐานข้อมูล
    dbConn.query(sql, [user_id], function(error, results, fields) {
        if (error) {
            // กรณีเกิดข้อผิดพลาดในการดึงข้อมูล
            console.error('Error fetching mbti_id for user_id:', user_id, error);
            res.status(500).json({ error: 'An error occurred while fetching data.' });
        } else {
            // ส่งข้อมูล mbti_id กลับไปยังผู้ใช้
            res.status(200).json(results);
        }
    });
});

// Soft Delete user_hasmany_mbti with user_id
app.put('/delete_soft_post/:post_id', function(req, res){
    let post_id = req.params.post_id;

    if(!post_id) {
        return res.status(400).send({ error: true, message: 'Please provide data' });
    }

    dbConn.query("UPDATE post SET del_status = 'Y' WHERE post_id = ? ", [post_id],
    function (error, results, fields) {
        if (error) {
            console.error('Error updating post:', error);
            return res.status(500).send({ error: true, message: 'An error occurred while updating data.' });
        }
        return res.send({ error: false, data: results, message: 'Post has been soft deleted successfully.'});
    });
});


// Soft Delete user_hasmany_mbti with user_id
app.put('/delete_soft/:user_id/:mbti_id', function(req, res){
    let user_id = req.params.user_id;
    let mbti_id = req.params.mbti_id;

    if(!user_id) {
        return res.status(400).send({ error: true, message: 'Please provide user_id' });
    }

    dbConn.query("UPDATE user_hasmany_mbti SET del_status = 'Y' WHERE user_id = ? AND mbti_id = ?", [user_id,mbti_id],
    function (error, results, fields) {
        if (error) {
            console.error('Error updating user_hasmany_mbti:', error);
            return res.status(500).send({ error: true, message: 'An error occurred while updating data.' });
        }
        return res.send({ error: false, data: results, message: 'User MBTI has been soft deleted successfully.'});
    });
});

// Soft Delete user_hasmany_mbti with user_id
app.put('/restore_usrmbti/:user_id', function(req, res){
    let user_id = req.params.user_id;
    if(!user_id) {
        return res.status(400).send({ error: true, message: 'Please provide user_id' });
    }

    dbConn.query("UPDATE user_hasmany_mbti SET del_status = 'N' WHERE user_id = ?", [user_id],
    function (error, results, fields) {
        if (error) {
            console.error('Error updating user_hasmany_mbti:', error);
            return res.status(500).send({ error: true, message: 'An error occurred while updating data.' });
        }
        return res.send({ error: false, data: results, message: 'User MBTI has been restore successfully.'});
    });
});



  app.post('/insertAccount', async function (req, res) {
    let post = req.body;
    let usr_id = post.usr_id
    let usr_name = post.usr_name
    let usr_password = post.usr_password
    let usr_mbti = post.usr_mbti
    let usr_gender = post.usr_gender
    let role = post.role
    const salt = await bcrypt.genSalt(10)
    let password_hash = await bcrypt.hash(usr_password,salt)
    if (!post) {
        return res.status(400).send({ error:true, message: 'Please provide a User data' });
    }
    dbConn.query('SELECT * FROM register_user WHERE usr_id = ?', [usr_id], function (error, results, fields) { 
        if (error) throw error;
        if (results[0]) {
            return res.status(400).send({ error:true, message: 'This User id is already in database.' });
        } else {
            if (!role) {
                var insertData = "INSERT INTO register_user(usr_id,usr_name,usr_password,usr_mbti,usr_gender) VALUES('" + usr_id + "','" + usr_name + "','" + password_hash + "','" + usr_mbti + "','" + usr_gender +"')";
            } else {
                var insertData = "INSERT INTO register_user(usr_id,usr_name,usr_password,usr_mbti,usr_gender,role) VALUES('" + usr_id + "','" + usr_name + "','" + password_hash + "','" + usr_mbti + "','"+ usr_gender +"','admin')";
            }
            dbConn.query(insertData, (error, results) => {
                if (error) throw error;
                return res.send(results);
            });
        }
    });
    
  });

  let multer = require('multer')
let path = require('path')
//use express static folder
app.use(express.static("./public"))

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
    extended: true
}));

// handle storage using multer
var storage = multer.diskStorage({
    destination: function (req, file, cb) {
        cb(null, 'uploads');
    },
    filename: function (req, file, cb) {
        cb(null, `image-${Date.now()}${path.extname(file.originalname)}`);
    }
});
    
var upload = multer({ storage: storage });

app.post('/insertAccountProfile', upload.single('image'), async function (req, res) {
    let post = req.body;
    let usr_id = post.usr_id
    let usr_name = post.usr_name
    let usr_password = post.usr_password
    let usr_mbti = post.usr_mbti
    let usr_gender = post.usr_gender
    let role = post.role
    const salt = await bcrypt.genSalt(10)
    let password_hash = await bcrypt.hash(usr_password, salt)
    
    // เช็คว่ามีไฟล์รูปภาพหรือไม่
    let fileImage = req.file;
    let imgsrc = null;
    if (fileImage) {
        imgsrc = 'http://10.0.2.2/studentApi/uploads/' + fileImage.filename;
    }

    if (!post) {
        return res.status(400).send({ error: true, message: 'Please provide a User data' });
    }

    dbConn.query('SELECT * FROM register_user WHERE usr_id = ?', [usr_id], function (error, results, fields) {
        if (error) throw error;
        if (results[0]) {
            return res.status(400).send({ error: true, message: 'This User id is already in database.' });
        } else {
            if (!role) {
                var insertData = "INSERT INTO register_user(usr_id,usr_name,usr_password,usr_mbti,usr_gender,profile) VALUES('" + usr_id + "','" + usr_name + "','" + password_hash + "','" + usr_mbti + "','" + usr_gender + "','" + imgsrc + "')";
            } else {
                var insertData = "INSERT INTO register_user(usr_id,usr_name,usr_password,usr_mbti,usr_gender,role,profile) VALUES('" + usr_id + "','" + usr_name + "','" + password_hash + "','" + usr_mbti + "','" + usr_gender + "','admin','" + imgsrc + "')";
            }
            dbConn.query(insertData, (error, results) => {
                if (error) throw error;
                return res.send(results);
            });
        }
    });

});


//   app.post('/addPost', async function (req, res) {
//     // รับข้อมูลจากโพสต์
//     let post = req.body;
//     let post_text = post.post_text;
//     let time_stamp = post.time_stamp;

//     // สร้างคำสั่ง SQL เพื่อเพิ่มข้อมูลโพสต์ลงในตารางโพสต์
//     const insertData = "INSERT INTO post (post_text, time_stamp) VALUES (?, ?)";
    
//     // แทรกข้อมูลโพสต์ลงในฐานข้อมูล
//     dbConn.query(insertData, [post_text, time_stamp], (error, results) => {
//         if (error) {
//             console.error('Error inserting post:', error);
//             return res.status(500).send({ error: true, message: 'An error occurred while inserting data.' });
//         }
//         return res.send(results);
//     });
// });


app.post('/addPostsUser', async function (req, res) {
    // รับข้อมูลจากโพสต์
    let data = req.body;
    let user_id = data.user_id;
    let post_id = data.post_id;

    // สร้างคำสั่ง SQL เพื่อเพิ่มข้อมูลลงในตาราง User_hasMany_Post
    const insertData = "INSERT INTO User_hasMany_Post (usr_id, post_id) VALUES (?, ?)";
    
    // แทรกข้อมูลลงในฐานข้อมูล
    dbConn.query(insertData, [user_id, post_id], (error, results) => {
        if (error) {
            console.error('Error inserting user post:', error);
            return res.status(500).send({ error: true, message: 'An error occurred while inserting data.' });
        }
        return res.send(results);
    });
});

app.get('/getUserPost/:post_text', function(req, res) {
    // รับ user_id ที่ส่งมาในคำขอ
    const post_text = req.params.post_text;
    if (!post_text) {
        return res.status(400).send({ error: true, message: 'Please provide post_text' });
    }
    // สร้างคำสั่ง SQL SELECT เพื่อดึงข้อมูล post_id จากตาราง post โดยใช้ user_id เป็นเงื่อนไข
    const sql = 'SELECT post_id FROM post WHERE post_text = ?';
    // ดำเนินการคิวรีข้อมูลในฐานข้อมูล
    dbConn.query(sql, [post_text], function(error, results, fields) {
        if (error) {
            // กรณีเกิดข้อผิดพลาดในการดึงข้อมูล
            console.error('Error fetching post_id for user_id:', user_id, error);
            res.status(500).json({ error: 'An error occurred while fetching data.' });
        } else {
            // ส่งข้อมูล post_id กลับไปยังผู้ใช้
            res.status(200).json(results);
        }
    });
});

app.post('/likePost', async function (req, res) {
    // รับข้อมูลจาก request body
    let data = req.body;
    let usr_id = data.usr_id;
    let post_id = data.post_id;
    let status = data.status;
    // ตรวจสอบว่ามีการกดไลค์จาก usr_id ใน post_id นี้แล้วหรือไม่
    const checkLikedQuery = "SELECT * FROM like_post WHERE usr_id = ? AND post_id = ?";
    
    // คิวรีฐานข้อมูลเพื่อตรวจสอบว่ามีการกดไลค์แล้วหรือไม่
    dbConn.query(checkLikedQuery, [usr_id, post_id], (error, results) => {
        if (error) {
            console.error('Error checking liked status:', error);
            return res.status(500).send({ error: true, message: 'An error occurred while checking liked status.' });
        }

        // ถ้ามีการกดไลค์แล้วใน post_id นี้
        if (results.length > 0) {
            return res.status(400).send({ error: true, message: 'You have already liked this post.' });
        } else {
            // สร้างคำสั่ง SQL เพื่อเพิ่มการกดไลค์ลงในตารางไลค์
            const insertLikeQuery = "INSERT INTO like_post (usr_id, post_id,status) VALUES (?, ?,?)";
            
            // แทรกข้อมูลการกดไลค์ลงในฐานข้อมูล
            dbConn.query(insertLikeQuery, [usr_id, post_id,status], (error, results) => {
                if (error) {
                    console.error('Error inserting like:', error);
                    return res.status(500).send({ error: true, message: 'An error occurred while inserting like data.' });
                }
                return res.send(results);
            });
        }
    });
});

app.post('/dislikePost', async function (req, res) {
    // รับข้อมูลจาก request body
    let data = req.body;
    let usr_id = data.usr_id;
    let post_id = data.post_id;
    let status = data.status;

    // คิวรีฐานข้อมูลเพื่อตรวจสอบว่ามีการกดไลค์โพสต์นี้จาก usr_id หรือไม่
    const checkLikedQuery = "SELECT * FROM like_post WHERE usr_id = ? AND post_id = ?";
    
    // ค้นหาในฐานข้อมูลเพื่อตรวจสอบว่ามีการถูกใจโพสต์นี้หรือไม่
    dbConn.query(checkLikedQuery, [usr_id, post_id], (error, results) => {
        if (error) {
            console.error('Error checking liked status:', error);
            return res.status(500).send({ error: true, message: 'An error occurred while checking liked status.' });
        }

        // ถ้ามีการถูกใจโพสต์นี้จาก usr_id
        if (results.length > 0) {
            // สร้างคำสั่ง SQL เพื่อลบการถูกใจโพสต์
            const deleteLikeQuery = "DELETE FROM like_post WHERE usr_id = ? AND post_id = ?";
            
            // ลบการถูกใจโพสต์จากฐานข้อมูล
            dbConn.query(deleteLikeQuery, [usr_id, post_id,], (error, results) => {
                if (error) {
                    console.error('Error deleting like:', error);
                    return res.status(500).send({ error: true, message: 'An error occurred while deleting like data.' });
                }
                return res.send({ success: true, message: 'Disliked post successfully.' });
            });
        } else {
            // ถ้าไม่มีการถูกใจโพสต์นี้จาก usr_id
            return res.status(400).send({ error: true, message: 'You have not liked this post.' });
        }
    });
});

//จำนวนไลค์ทั้งหมดของทุกโพส 
app.get('/getLikesCount/:post_id', function(req, res) {
    // รับ post_id ที่ส่งมาในคำขอ
    const post_id = req.params.post_id;
    if (!post_id) {
        return res.status(400).send({ error: true, message: 'Please provide post_id' });
    }
    // สร้างคำสั่ง SQL SELECT เพื่อนับจำนวนคนที่ไลค์โพสต์นี้จากตาราง like_post โดยใช้ post_id เป็นเงื่อนไข
    const sql = 'SELECT COUNT(*) AS likes_count FROM like_post WHERE post_id = ?';
    // ดำเนินการคิวรีข้อมูลในฐานข้อมูล
    dbConn.query(sql, [post_id], function(error, results, fields) {
        if (error) {
            // กรณีเกิดข้อผิดพลาดในการดึงข้อมูล
            console.error('Error fetching likes count for post_id:', post_id, error);
            res.status(500).json({ error: 'An error occurred while fetching data.' });
        } else {
            // ส่งจำนวนคนที่ไลค์โพสต์นี้กลับไปยังผู้ใช้
            res.status(200).json(results[0]); // เนื่องจากเราใช้ COUNT(*) ดังนั้นผลลัพธ์จะมีแค่รายการเดียว
        }
    });
});


app.get('/getLikesStatus/:usr_id', function(req, res) {
    // รับ usr_id ที่ส่งมาในคำขอ
    const usr_id = req.params.usr_id;
    if (!usr_id) {
        return res.status(400).send({ error: true, message: 'Please provide usr_id' });
    }
    // สร้างคำสั่ง SQL SELECT เพื่อเรียกดู status ของการไลค์โพสต์ทั้งหมดของ usr_id จากตาราง like_post
    const sql = 'SELECT post_id, status FROM like_post WHERE usr_id = ?';
    // ดำเนินการคิวรีข้อมูลในฐานข้อมูล
    dbConn.query(sql, [usr_id], function(error, results, fields) {
        if (error) {
            // กรณีเกิดข้อผิดพลาดในการดึงข้อมูล
            console.error('Error fetching like status for usr_id:', usr_id, error);
            res.status(500).json({ error: 'An error occurred while fetching data.' });
        } else {
            // ส่งข้อมูล status ของการไลค์โพสต์ทั้งหมดกลับไปยังผู้ใช้
            res.status(200).json(results);
        }
    });
});



app.post('/addPost', (req, res) => {
    // รับข้อมูลจากโพสต์
    let post = req.body;
    let usr_name = post.usr_name;
    let post_text = post.post_text;


    // สร้างคำสั่ง SQL เพื่อเพิ่มข้อมูลโพสต์ลงในตารางโพสต์
    const insertData = "INSERT INTO post (post_text,usr_name) VALUES (?,?)";
    
    // แทรกข้อมูลโพสต์ลงในฐานข้อมูล
    dbConn.query(insertData, [post_text,usr_name], (error, results) => {
        if (error) {
            console.error('Error inserting post:', error);
            return res.status(500).json({ error: true, message: 'An error occurred while inserting data.' });
        }
        // return success response
        return res.status(201).json({ success: true, message: 'Post successfully.', result: results });
    });
});




app.post('/addPostWithImg', upload.single('image'), (req, res) => {
    // รับข้อมูลจากโพสต์
    let post = req.body;
    let usr_id = post.usr_id;
    let post_text = post.post_text;
    var fileImage = req.file;
    if (!fileImage) {
        console.log('No file uploaded');
        return res.status(400).json({ error: true, message: 'No file uploaded' });
    } else {
        var imgsrc = 'http://10.0.2.2/studentApi/uploads/' + fileImage.filename
    }

    // สร้างคำสั่ง SQL เพื่อเพิ่มข้อมูลโพสต์ลงในตารางโพสต์
    const insertData = "INSERT INTO post (post_text,usr_id,img_post) VALUES (?,?,?)";
    
    // แทรกข้อมูลโพสต์ลงในฐานข้อมูล
    dbConn.query(insertData, [post_text, usr_id, imgsrc], (error, results) => {
        if (error) {
            console.error('Error inserting post:', error);
            return res.status(500).json({ error: true, message: 'An error occurred while inserting data.' });
        }
        // return success response
        return res.status(201).json({ success: true, message: 'Post with image uploaded successfully.', result: results });
    });
});

// API สำหรับอัปเดตข้อมูลโพรไฟล์
app.put('/editProfile/:usr_id', upload.single('profile'), (req, res) => {
    // รับข้อมูลจากโพสต์
    var usr_id = req.body.usr_id;
    var usr_name = req.body.usr_name;
    var usr_gender = req.body.usr_gender;
    var fileImage = req.file;

    if (!fileImage) {
        console.log('No file uploaded');
        return res.status(400).json({ error: true, message: 'No file uploaded' });
    }

    var imgsrc = 'http://10.0.2.2/studentApi/uploads/' + fileImage.filename;

    // สร้างคำสั่ง SQL เพื่ออัปเดตข้อมูลโพรไฟล์ในฐานข้อมูล
    const updateData = "UPDATE register_user SET usr_name = ?, usr_gender = ?, profile = ? WHERE usr_id = ?";

    // อัปเดตข้อมูลโพรไฟล์ในฐานข้อมูล
    dbConn.query(updateData, [usr_name, usr_gender, imgsrc, usr_id], (error, results) => {
        if (error) {
            console.error('Error updating profile:', error);
            return res.status(500).json({ error: true, message: 'An error occurred while updating profile.' });
        }
        // ส่งข้อมูลการอัปเดตโพรไฟล์กลับ
        return res.status(200).json({ success: true, message: 'Profile updated successfully.', result: results });
    });
});

app.post('/editNamePost/:old_name', (req, res) => {
    // รับข้อมูลจาก HTTP request
    const usr_name = req.body.usr_name;
    const old_name = req.body.old_name;

    // ทำการอัปเดตข้อมูลในตาราง "post"
    const updatePostData = "UPDATE register_user SET usr_name = ? WHERE usr_name = ?";
    dbConn.query(updatePostData, [usr_name, old_name], (error, results) => {
        if (error) {
            console.error('Error updating post user name:', error);
            return res.status(500).json({ error: true, message: 'An error occurred while updating post user name.' });
        }

        // ส่งข้อมูลการอัปเดตโพรไฟล์กลับ
        return res.status(200).json({ success: true, message: 'Profile updated successfully.', result: results });
    });
});

// app.put('/editProfile/:usr_id', upload.single('profile'), (req, res) => {
//     // รับข้อมูลจากโพสต์
//     var usr_id = req.body.usr_id;
//     var usr_name = req.body.usr_name;
//     var usr_gender = req.body.usr_gender;
//     var old_name = req.body.old_name;
//     var fileImage = req.file;

//     if (!fileImage) {
//         console.log('No file uploaded');
//         return res.status(400).json({ error: true, message: 'No file uploaded' });
//     }

//     var imgsrc = 'http://10.0.2.2/studentApi/uploads/' + fileImage.filename;

//     // สร้างคำสั่ง SQL เพื่ออัปเดตข้อมูลโพรไฟล์ในฐานข้อมูล
// // อัปเดตข้อมูลในตารางโพส
// const updatePostData = "UPDATE post SET usr_name = ? WHERE usr_name = ?";
// dbConn.query(updatePostData, [usr_name, old_name], (error, results) => {
//     if (error) {
//         console.error('Error updating post user name:', error);
//         return res.status(500).json({ error: true, message: 'An error occurred while updating post user name.' });
//     }

//     // อัปเดตข้อมูลในตารางผู้ใช้
//     const updateUserData = "UPDATE register_user SET usr_name = ?, usr_gender = ?, profile = ? WHERE usr_id = ?";
//     dbConn.query(updateUserData, [usr_name, usr_gender, imgsrc, usr_id], (error, results) => {
//         if (error) {
//             console.error('Error updating user profile:', error);
//             return res.status(500).json({ error: true, message: 'An error occurred while updating user profile.' });
//         }

//         // ส่งข้อมูลการอัปเดตโพรไฟล์กลับ
//         return res.status(200).json({ success: true, message: 'Profile updated successfully.', result: results });
//     });
// });
// });

app.put('/postUpdate/:post_id', upload.single('img_post'), (req, res) => {
    // รับข้อมูลจากโพสต์
    var post_id = req.body.post_id;
    var usr_id = req.body.usr_id;
    var post_text = req.body.post_text;
    var fileImage = req.file;

    // ตรวจสอบว่ามีการอัปโหลดไฟล์ภาพหรือไม่
    if (!fileImage) {
        console.log('No file uploaded');
        return res.status(400).json({ error: true, message: 'No file uploaded' });
    }

    // สร้าง URL สำหรับภาพที่อัปโหลด
    var imgsrc = 'http://10.0.2.2/studentApi/uploads/' + fileImage.filename;

    // สร้างคำสั่ง SQL เพื่ออัปเดตข้อมูลโพสต์ในฐานข้อมูล
    const updateData = "UPDATE post SET usr_id = ?, post_text = ?, img_post = ? WHERE post_id = ?";

    // อัปเดตข้อมูลโพสต์ในฐานข้อมูล
    dbConn.query(updateData, [usr_id, post_text, imgsrc, post_id], (error, results) => {
        if (error) {
            console.error('Error updating img_post:', error);
            return res.status(500).json({ error: true, message: 'An error occurred while updating img_post.' });
        }
        // ส่งข้อมูลการอัปเดตโพสต์กลับ
        return res.status(200).json({ success: true, message: 'img_post updated successfully.', result: results });
    });
});



  app.listen(3000, function(){
    console.log('Node app is running on port 3000');
});
module.exports = app;


