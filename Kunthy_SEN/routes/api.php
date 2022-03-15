<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\UserController;
use App\Http\Controllers\PostController;
use App\Http\Controllers\CommentController;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});

// routes for users
Route::get('/users', [UserController::class ,'getAllUsers']);
Route::get('/users_posts_comments', [UserController::class ,'getUsers']);
Route::post('/users', [UserController::class,'createNewUser']);

// routes for posts
Route::get('/posts', [PostController::class ,'getAllPosts']);
Route::get('/posts_comments', [PostController::class ,'getPosts']);
Route::post('/posts', [PostController::class,'createNewPost']);

// routes for comment
Route::get('/comments', [CommentController::class ,'getAllComments']);
Route::post('/comments', [CommentController::class,'createNewComment']);

