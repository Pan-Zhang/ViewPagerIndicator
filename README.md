# ViewPagerIndicator
实现了两种指示器，一种下面圆点跟随跳跃式指示（ViewPagerIndicator），一种滑动跟随式指示（ViewPagerIndicator2），第二种是基于第一种进行的扩展。

使用方法：
均可作为普通组件在布局文件中引入，初始化方法也跟普通组件一样。

第一种指示器（ViewPagerIndicator）的使用主要有两个公共方法就可以了，一个是setLength（intlength)方法，设置小点个数。第二个是
setSelected(int selected)方法，设置当前哪一个小点被选中。若要实现跟随滑动效果，只需要为ViewPager添加OnPageChangeListener监听，并在
onPageSelected(int position)中调用即可。

第二种指示器（ViewPagerIndicator2）基于第一种扩展实现，使用更简单，只需用
setViewPager(ViewPager viewPager, int sum)方法即可。第一个参数是要监听的viewpager，第二个参数为小点的个数。

注意：第二种方法使用后如果需要对ViewPager的滑动进行监听请调用ViewPagerIndicator2提供的回调，方法名和参数以及使用方法与ViewPager的滑动监听一样，具体参见源码。
