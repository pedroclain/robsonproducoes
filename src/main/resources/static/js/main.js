/* ===================================================================
 * Kairos - Main JS
 *
 * ------------------------------------------------------------------- */


(function ($) {

  "use strict";

  var cfg = {
    scrollDuration: 800, // smoothscroll duration
    mailChimpURL: 'https://facebook.us8.list-manage.com/subscribe/post?u=cdb7b577e41181934ed6a6a44&amp;id=e6957d85dc'   // mailchimp url
  },
          $WIN = $(window);

  // Add the User Agent to the <html>
  // will be used for IE10 detection (Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0))
  var doc = document.documentElement;
  doc.setAttribute('data-useragent', navigator.userAgent);


  /* Preloader
   * -------------------------------------------------- */
  var ssPreloader = function () {

    $("html").addClass('ss-preload');

    $WIN.on('load', function () {

      //force page scroll position to top at page refresh
      $('html, body').animate({scrollTop: 0}, 'normal');

      // will first fade out the loading animation 
      $("#loader").fadeOut("slow", function () {
        // will fade out the whole DIV that covers the website.
        $("#preloader").delay(300).fadeOut("slow");
      });

      // for hero content animations 
      $("html").removeClass('ss-preload');
      $("html").addClass('ss-loaded');

    });
  };


  /* Menu on Scrolldown
   * ------------------------------------------------------ */
  var ssMenuOnScrolldown = function () {

    var hdr = $('.s-header'),
            hdrTop = $('.s-header').offset().top;

    $WIN.on('scroll', function () {

      if ($WIN.scrollTop() > hdrTop) {
        hdr.addClass('sticky');
      } else {
        hdr.removeClass('sticky');
      }

    });
  };


  /* Mobile Menu
   * ---------------------------------------------------- */
  var ssMobileMenu = function () {

    var toggleButton = $('.header-menu-toggle'),
            nav = $('.header-nav-wrap');

    toggleButton.on('click', function (event) {
      event.preventDefault();

      toggleButton.toggleClass('is-clicked');
      nav.slideToggle();
    });

    if (toggleButton.is(':visible'))
      nav.addClass('mobile');

    $WIN.on('resize', function () {
      if (toggleButton.is(':visible'))
        nav.addClass('mobile');
      else
        nav.removeClass('mobile');
    });

    nav.find('a').on("click", function () {

      if (nav.hasClass('mobile')) {
        toggleButton.toggleClass('is-clicked');
        nav.slideToggle();
      }
    });

  };


  /* Highlight the current section in the navigation bar
   * ------------------------------------------------------ */
  var ssWaypoints = function () {

    var sections = $(".target-section"),
            navigation_links = $(".header-nav-wrap li a");

    sections.waypoint({

      handler: function (direction) {

        var active_section;

        active_section = $('section#' + this.element.id);

        if (direction === "up")
          active_section = active_section.prevAll(".target-section").first();

        var active_link = $('.header-nav-wrap li a[href="#' + active_section.attr("id") + '"]');

        navigation_links.parent().removeClass("current");
        active_link.parent().addClass("current");

      },

      offset: '25%'

    });

  };


  /* slick slider
   * ------------------------------------------------------ */
  var ssSlickSlider = function () {

    $('.about-desc__slider').slick({
      arrows: false,
      dots: true,
      infinite: true,
      slidesToShow: 4,
      slidesToScroll: 1,
      pauseOnFocus: false,
      autoplaySpeed: 1500,
      responsive: [
        {
          breakpoint: 1401,
          settings: {
            slidesToShow: 3,
            slidesToScroll: 1
          }
        },
        {
          breakpoint: 1101,
          settings: {
            slidesToShow: 2,
            slidesToScroll: 1
          }
        },
        {
          breakpoint: 701,
          settings: {
            slidesToShow: 1,
            slidesToScroll: 1
          }
        }
      ]
    });

    $('.testimonials__slider').slick({
      arrows: false,
      dots: true,
      infinite: true,
      slidesToShow: 2,
      slidesToScroll: 1,
      pauseOnFocus: false,
      autoplaySpeed: 1500,
      responsive: [
        {
          breakpoint: 1001,
          settings: {
            slidesToShow: 1,
            slidesToScroll: 1
          }
        }
      ]
    });
  };


  /* Smooth Scrolling
   * ------------------------------------------------------ */
  var ssSmoothScroll = function () {

    $('.smoothscroll').on('click', function (e) {
      var target = this.hash,
              $target = $(target);

      e.preventDefault();
      e.stopPropagation();

      $('html, body').stop().animate({
        'scrollTop': $target.offset().top
      }, cfg.scrollDuration, 'swing').promise().done(function () {

        // check if menu is open
        // if ($('body').hasClass('menu-is-open')) {
        //     $('.header-menu-toggle').trigger('click');
        // }

        window.location.hash = target;
      });
    });

  };


  /* Alert Boxes
   * ------------------------------------------------------ */
  var ssAlertBoxes = function () {

    $('.alert-box').on('click', '.alert-box__close', function () {
      $(this).parent().fadeOut(500);
    });

  };


  /* Animate On Scroll
   * ------------------------------------------------------ */
  var ssAOS = function () {

    AOS.init({
      offset: 200,
      duration: 600,
      easing: 'ease-in-sine',
      delay: 300,
      once: true
    });

  };


  /* Back to Top
   * ------------------------------------------------------ */
  var ssBackToTop = function () {

    var pxShow = 500,
            goTopButton = $(".go-top");

    // Show or hide the button
    if ($(window).scrollTop() >= pxShow)
      goTopButton.addClass('link-is-visible');

    $(window).on('scroll', function () {
      if ($(window).scrollTop() >= pxShow) {
        if (!goTopButton.hasClass('link-is-visible'))
          goTopButton.addClass('link-is-visible')
      } else {
        goTopButton.removeClass('link-is-visible')
      }
    });
  };


  /* AjaxChimp
   * ------------------------------------------------------ */
//  var ssAjaxChimp = function () {
//
//    $('#mc-form').ajaxChimp({
//      language: 'es',
//      url: cfg.mailChimpURL
//    });
//
//
//    $.ajaxChimp.translations.es = {
//      'submit': 'Submitting...',
//      0: '<i class="fas fa-check"></i> We have sent you a confirmation email',
//      1: '<i class="fas fa-exclamation-triangle"></i> You must enter a valid e-mail address.',
//      2: '<i class="fas fa-exclamation-triangle"></i> E-mail address is not valid.',
//      3: '<i class="fas fa-exclamation-triangle"></i> E-mail address is not valid.',
//      4: '<i class="fas fa-exclamation-triangle"></i> E-mail address is not valid.',
//      5: '<i class="fas fa-exclamation-triangle"></i> E-mail address is not valid.'
//    }
//  };

  /* Initialize
   * ------------------------------------------------------ */
  (function clInit() {

    ssPreloader();
    ssMenuOnScrolldown();
    ssMobileMenu();
    ssWaypoints();
    ssSlickSlider();
    ssSmoothScroll();
    ssAlertBoxes();
    ssAOS();
    ssBackToTop();
//    ssAjaxChimp();



  })();

})(jQuery);


// player elements

let songs = ["audios/audio01.mp3", "audios/audio01.mp3"];
let isPlaying = false;
let controlPlay = $('.control-play');
let controlPlayIconEl = $('.control-play i');
let controlBackEl = $('.control-back');
let controlForwardsEl = $('.control-forwards');
let playerEl = $('.music-player-container');
let audioEl = document.getElementById('audio');
let songItemEl = $('.song-item')[0];
let artistNameEl = $('.artist-name')[0];
let albumTitleEl = $('.album-title')[0];
let songTitleEl = $('.song-title')[0];

// file element

let downloadIconEl = $('.fa-download')[0];

// category elements

let gospelContainer = $('#gospel-category-container');
let gospelLink = $('#gospel-category-link')[0];
let sertanejoContainer = $('#sertanejo-category-container');
let sertanejoLink = $('#sertanejo-category-link')[0];
let forroContainer = $('#forro-category-container');
let forroLink = $('#forro-category-link')[0];

controlPlay.on('click', function() {
  togglePlayPause();
});

gospelContainer.on('click', function() {
  gospelLink.click();
});

sertanejoContainer.on('click', function() {
  sertanejoLink.click();
});

forroContainer.on('click', function() {
  forroLink.click();
});



function togglePlayPause() {
  isPlaying ? pause() : play();
}

function play() {
  audioEl.play();
  playerEl.addClass('is-playing');
  controlPlayIconEl.removeClass("fa-play-circle");
  controlPlayIconEl.addClass("fa-pause-circle");
  isPlaying = true;
}

function pause() {
  audioEl.pause();
  playerEl.removeClass('is-playing');
  controlPlayIconEl.removeClass("fa-pause-circle");
  controlPlayIconEl.addClass("fa-play-circle");
  isPlaying = false;
}

function setAudio(el, songName, autorName, categoryName, fileName) {
  console.log('inside')
  $('.active').removeClass('active');
  $(el).addClass('active');
  artistNameEl.innerText = songName;
  albumTitleEl.innerText = categoryName;
  songTitleEl.innerText = `"${autorName}"`;
  pause();
  audioEl.src = `https://robsonproducoesstorage.blob.core.windows.net/songs/${fileName}`;
  togglePlayPause();
};

function uploadFile() {
  $('#upload-input').trigger('click');
}

function changeFileName() {
  let path = $('#upload-input').val();
  let fileName = path.replace(/C:\\fakepath\\/, '');
  $('#upload-placeholder').val(fileName);
}

function downloadFile(fileName) {
  $("#downloadLink").attr({target: "_blank"}, {href: `https://robsonproducoesstorage.blob.core.windows.net/songs/${fileName}`});
}

