<template>
  <div>
    <Header />
    <div class="search_bar" style="width: 500px;margin: auto">
      <el-input @input="recoverdata" @keyup.enter="searchnow" type="text" v-model="input" placeholder="请输入要查找的名称" />
      <el-button type="primary" @click="searchnow">搜索</el-button>
      <!-- <el-button type="primary" @click="addBooks">添加</el-button> -->
    </div>
    <el-button type="primary" @click="add=true" :disabled="this.$route.query.type==1">add new book</el-button>
    <div style="width:2500px;margin: 0 auto;padding-left:300px">
      <!-- 搜索项目栏 -->
      <el-table :data="showData" style="width: 100%;">
        <el-table-column prop="name" label="bookName" width="150" >
        <template v-slot="scope">
          <div>
            <a :href="'/bookInformation?userid='+this.$route.query.userid+'&username='+this.$route.query.username+'&bid='+scope.row.id">{{scope.row.name}}</a>
          </div>
        </template>
        </el-table-column>
        <el-table-column prop="author" label="author" width="120" />
        <el-table-column prop="isbn" label="ISBN" width="120" />
        <el-table-column prop="description" label="description" width="300" />
        <el-table-column prop="inventory" label="inventory" width="70" />
        <el-table-column prop="image" label="image" width="200">
          <template v-slot="e">
            <el-image style="width: 100px; height: 100px" :src="e.row.image" fit="contain"></el-image>
          </template>
        </el-table-column>
        <el-table-column fixed="right" label="Operations" width="120">
          <template v-slot="scope">
            <el-button link type="primary" size="small" @click="Edit(scope.row)" :disabled="this.$route.query.type==1">
              Edit</el-button>
            <el-button link type="primary" size="small" @click="Delete(scope.row)"
              :disabled="this.$route.query.type==1">Delete</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>
    <!--      edit-->
    <el-dialog v-model="edit" title="edit book">
      <el-form :model="book">
        <el-form-item label="book name" :label-width="formLabelWidth">
          <el-input v-model="book.name" autocomplete="off" />
        </el-form-item>
        <el-form-item label="author" :label-width="formLabelWidth">
          <el-input v-model="book.author" autocomplete="off" />
        </el-form-item>
        <el-form-item label="inventory" :label-width="formLabelWidth">
          <el-input v-model="book.inventory" autocomplete="off" />
        </el-form-item>
        <el-form-item label="ISBN" :label-width="formLabelWidth">
          <el-input v-model="book.isbn" autocomplete="off" />
        </el-form-item>
        <el-form-item label="image" :label-width="formLabelWidth">
          <el-input v-model="book.image" autocomplete="off" />
        </el-form-item>
        <img :src="book.image" style="width: 200px;margin: auto"/>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="edit = false">Cancel</el-button>
          <el-button type="primary" @click="updateEdit()">Confirm</el-button>
        </span>
      </template>
    </el-dialog>

    <!-- add -->
    <el-dialog v-model="add" title="add new book">
      <el-form :model="new_book">
        <el-form-item label="book name" :label-width="formLabelWidth">
          <el-input v-model="new_book.name" autocomplete="off" />
        </el-form-item>
        <el-form-item label="author" :label-width="formLabelWidth">
          <el-input v-model="new_book.author" autocomplete="off" />
        </el-form-item>
        <el-form-item label="ISBN" :label-width="formLabelWidth">
          <el-input v-model="new_book.isbn" autocomplete="off" />
        </el-form-item>
        <el-form-item label="description" :label-width="formLabelWidth">
          <el-input v-model="new_book.description" autocomplete="off" />
        </el-form-item>
        <el-form-item label="type" :label-width="formLabelWidth">
          <el-input v-model="new_book.type" autocomplete="off" />
        </el-form-item>
        <el-form-item label="inventory" :label-width="formLabelWidth">
          <el-input v-model="new_book.inventory" autocomplete="off" />
        </el-form-item>
        <el-form-item label="price" :label-width="formLabelWidth">
          <el-input v-model="new_book.price" autocomplete="off" />
        </el-form-item>
        <el-form-item label="image" :label-width="formLabelWidth">
          <el-input v-model="new_book.image" autocomplete="off" />
        </el-form-item>
        <img :src="new_book.image" style="width: 200px;margin: auto"/>
      </el-form>
      <template #footer>
        <span class="dialog-footer">
          <el-button @click="add = false">Cancel</el-button>
          <el-button type="primary" @click="addConfirm()">Confirm</el-button>
        </span>
      </template>
    </el-dialog>
    <Footer />
  </div>
</template>

<script>
import Header from "@/components/Head";
import Footer from  "@/components/Foot";
import {instance} from "@/axios/axios";
const formLabelWidth = '140px'
export default {
  // name: 'Login',
  components:{
    Header,
    Footer
  },
  created(){
    instance.get("/getBooks").then(res=>{
      res.data.forEach(item=>{
        this.BookData.push({
          id:item.bookId,
          isbn:item.isbn,
          name: item.bookName,
          price:item.price,
          type:item.bookType,
          author:item.author,
          description:item.bookDescription,
          inventory:item.inventory,
          image:item.image,
          // image:require('@/assets/img/logo.png')
        })
      })
    }).catch(err=>{
      console.log(err);
    })
    this.showData=this.BookData;
  },
  methods: {
    handleClick(row) {
      console.log(row);
    },
    Edit(n){
      this.book.id=n.id;
      this.book.name=n.name;
      this.book.isbn=n.isbn;
      this.book.author=n.author;
      this.book.inventory=n.inventory;
      this.book.image=n.image;
      this.edit=true;
    },
    updateEdit(){
      console.log(this.book.id);
      console.log(this.book.inventory);
      instance.get('/EditBook',{
        params:{
          bookid:this.book.id,
          name:this.book.name,
          author: this.book.author,
          inventory: this.book.inventory,
          isbn:this.book.isbn,
          image:this.book.image,
        }
      }).then(res=>{
        console.log(res);
      }).catch(err=>{
        console.log(err);
      })
      this.edit = false;
      window.location.reload();
    },
    Delete(n){
      console.log(n.id);
      instance.get('/deleteBook',{
        params:{
          bookid:n.id,
        }
      }).then(res=>{
        console.log(res);
      }).catch(err=>{
        console.log(err);
      })
      window.location.reload();
    },
    addConfirm(){
      instance.post('/addBook',null,{
        params:{
          bookName:this.new_book.name,
          author:this.new_book.author,
          isbn:this.new_book.isbn,
          description:this.new_book.description,
          type:this.new_book.type,
          inventory:this.new_book.inventory,
          price:this.new_book.price,
          image:this.new_book.image,
        }
      }).then(res=>{
        console.log(res.data);
      }).catch(err=>{
        console.log(err);
      })
      window.location.reload();
    },
    searchnow(){
      // var searchitem = [];
      // var temp = String(this.input).toUpperCase();
      // this.BookData.forEach(function (item) {
      //   if (String(item.name).toUpperCase().indexOf(temp) > -1) {
      //     searchitem.push(item);
      //   }
      // });
      // this.showData = JSON.parse(JSON.stringify(searchitem));
      console.log("search!")
      instance.post("SearchBookbyDescrip",null,{
        params:{
          keyword:this.input,
        }
      }).then(res=>{
        console.log(res)
      //   res.data.forEach(item=>{
      //   this.showData.push({
      //     id:item.book_id,
      //     isbn:item.isbn,
      //     name: item.book_name,
      //     price:item.price,
      //     type:item.bookType,
      //     author:item.author[0],
      //     description:item.bookDescription,
      //     inventory:item.inventory,
      //     image:item.image,
      //     // image:require('@/assets/img/logo.png')
      //   })
      // })
      this.showData=[]
      res.data.forEach(item=>{
        var obj = JSON.parse(item);
        console.log(obj)
        this.showData.push({
          id:obj.book_id,
          isbn:obj.isbn[0],
          name:obj.book_name[0],
          price:obj.price[0].split(':')[1],
          type:obj.bookType[0],
          author:obj.author[0],
          description:obj.bookDescription[0],
          inventory:obj.inventory[0],
          image:obj.image[0]
        })
      })
      console.log(this.showData);
      }).catch(err=>{
        console.log(err);
      })
    },
    recoverdata(){
      if(this.input=="")
        this.showData=this.BookData;
    },
  },

  data() {
    return {
      BookData:[
        // {name:"hhh",password:"123",type:1}
      ],
      input:"",
      showData:[],
      edit:false,
      add:false,
      book:{
        id:null,
        name:'',
        author:"",
        inventory:null,
        isbn:null
      },
      new_book:{
        name:'',
        author:"",
        isbn:null,
        description:'',
        type:'',
        inventory:null,    
        price:'',
      }
    }
  }
}
</script>
<style scoped>
.search_bar {
  margin: 10px;
  display: flex;
  justify-content: space-around;
}
</style>