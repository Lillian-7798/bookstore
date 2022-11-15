<template>
  <div>
    <Header />
    <Book />
    <Footer />
  </div>
</template>

<script>
import Header from "@/components/Head";
import Footer from  "@/components/Foot";
import Book from "./book";
export default {
  // name: 'Home',
  components:{
    Header,
    Book,
    Footer,
  },
};
</script>

<style scoped>

</style>