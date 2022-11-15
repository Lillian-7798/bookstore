<template>
  <div class="home">
    <Header />
<!--    <h1>home</h1>-->
    <div>
        <Adv />
        <Recommand />
    </div>
    <Footer />
  </div>
</template>

<script>
import Header from "@/components/Head";
import Footer from  "@/components/Foot";
import Adv from "./advertisement";
import Recommand from "./recommand"
export default {
  // name: 'Home',
  components:{
    Header,
    Adv,
    Recommand,
    Footer,
  },
};
</script>

<style scoped>

</style>