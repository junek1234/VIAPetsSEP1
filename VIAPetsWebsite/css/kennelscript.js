
$('#topCircle').hover(
  function() {
    // Hover: Increase size by 10%
    let currentWidth = $(this).width();
    let currentHeight = $(this).height();

    let newWidth = currentWidth * 1.10;
    let newHeight = currentHeight * 1.10;

    $(this).animate({ width: newWidth + 'px', height: newHeight + 'px' }, 50, 'swing');
  },
  function() {
    // Mouse leaves:
    $(this).animate({ width: '110px', height: '110px' }, 25, 'swing');
  }
);

$('#middleCircle').hover(
  function() {
    // Hover: Increase size by 10%
    let currentWidth = $(this).width();
    let currentHeight = $(this).height();

    let newWidth = currentWidth * 1.10;
    let newHeight = currentHeight * 1.10;

    $(this).animate({ width: newWidth + 'px', height: newHeight + 'px' }, 50, 'swing');
  },
  function() {
    // Mouse leaves:
    $(this).animate({ width: '100px', height: '100px' }, 25, 'swing');
  }
);

$('#bottomCircle').hover(
  function() {
    // Hover: Increase size by 10%
    let currentWidth = $(this).width();
    let currentHeight = $(this).height();

    let newWidth = currentWidth * 1.10;
    let newHeight = currentHeight * 1.10;

    $(this).animate({ width: newWidth + 'px', height: newHeight + 'px' }, 50, 'swing');
  },
  function() {
    // Mouse leaves:
    $(this).animate({ width: '80px', height: '80px' }, 25, 'swing');
  }
);

$("#dog").hover(
  function() {
    // Hover: Increase size by 10%
    let currentWidth = $(this).width();
    let currentHeight = $(this).height();

    let newWidth = currentWidth * 1.10;
    let newHeight = currentHeight * 1.10;

    $(this).animate({ width: newWidth + 'px', height: newHeight + 'px' }, 300, 'swing');
  },
  function() {
    // Mouse leaves:
    $(this).animate({ width: '250px', height: '250px' }, 300, 'swing');
  }
);

$("#cat").hover(
  function() {
    // Hover: Increase size by 10%
    let currentWidth = $(this).width();
    let currentHeight = $(this).height();

    let newWidth = currentWidth * 1.10;
    let newHeight = currentHeight * 1.10;

    $(this).animate({ width: newWidth + 'px', height: newHeight + 'px' }, 300, 'swing');
  },
  function() {
    // Mouse leaves:
    $(this).animate({ width: '250px', height: '250px' }, 300, 'swing');
  }
);

$("#bird").hover(
  function() {
    // Hover: Increase size by 10%
    let currentWidth = $(this).width();
    let currentHeight = $(this).height();

    let newWidth = currentWidth * 1.10;
    let newHeight = currentHeight * 1.10;

    $(this).animate({ width: newWidth + 'px', height: newHeight + 'px' }, 300, 'swing');
  },
  function() {
    // Mouse leaves:
    $(this).animate({ width: '250px', height: '250px' }, 300, 'swing');
  }
);

  /* When you scroll a bit the circles transform into rectangle :D */
  /*$(window).scroll(function() {
    if ($(window).scrollTop() > 200) {
      
      $('#bottomCircle').addClass('rectangle').text('Beautiful Creatures');
      $('#middleCircle').addClass('rectangle').text('+5,000');
      $('#topCircle').addClass('rectangle').text('Took care of');
  
      
      $('#bottomCircle').animate({ left: '+=50', top: '+=100' }, 'slow', 'swing');
      $('#middleCircle').animate({ left: '+=50', top: '+=100' }, 'slow', 'swing');
      $('#topCircle').animate({ left: '+=50', top: '+=100' }, 'slow', 'swing');
    } else {
      
      $('#bottomCircle').removeClass('rectangle').text('Original Text 1');
      $('#middleCircle').removeClass('rectangle').text('Original Text 2');
      $('#topCircle').removeClass('rectangle').text('Original Text 3');
  
      $('#bottomCircle').animate({ left: '-=50', top: '-=100' }, 'slow', 'swing');
      $('#middleCircle').animate({ left: '-=50', top: '-=100' }, 'slow', 'swing');
      $('#topCircle').animate({ left: '-=50', top: '-=100' }, 'slow', 'swing');
    }
  });*/
  