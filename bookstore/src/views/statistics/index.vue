<template>
  <div>
    <Header />
    <ST />
    <Footer />
  </div>
</template>

<script>
import Header from "@/components/Head";
import Footer from  "@/components/Foot";
import ST from  "./statistics"
export default {
  components:{
    Header,
    ST,
    Footer,
  },
};
</script>

<style scoped>

</style>