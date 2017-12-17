const gulp = require('gulp');
const requireDir = require('require-dir');
const minifyCSS = require('gulp-minify-css');
const minifyJS = require('gulp-uglify');
const minifyHTML = require('gulp-htmlmin');

requireDir('./tasks');



gulp.task('default', ['minify-css', 'minify-css-vendors','minify-js','minify-js-vendors','minify-html', 'minify-views' ], function () {

});

gulp.task('minify-css', function() {
   return gulp.src('../css/app.css')
       .pipe(minifyCSS())
       .pipe(gulp.dest('../../static/css/'))
});

gulp.task('minify-css-vendors', function() {
    return gulp.src('../vendors/**/*.css')
        .pipe(minifyCSS())
        .pipe(gulp.dest('../../static/vendors/'))
});

gulp.task('minify-js', function() {
    return gulp.src('../app/**/*.js')
        .pipe(minifyJS())
        .pipe(gulp.dest('../../static/app/'))
});

gulp.task('minify-js-vendors', function() {
    return gulp.src('../vendors/**/*.js')
        .pipe(minifyJS())
        .pipe(gulp.dest('../../static/vendors/'))
});

gulp.task('minify-html', function() {
    return gulp.src('../*.html')
        .pipe(minifyHTML({collapseWhitespace: true}))
        .pipe(gulp.dest('../../static'));
});

gulp.task('minify-views', function() {
    return gulp.src('../app/**/*.html')
        .pipe(minifyHTML({collapseWhitespace: true}))
        .pipe(gulp.dest('../../static/app/'));
});