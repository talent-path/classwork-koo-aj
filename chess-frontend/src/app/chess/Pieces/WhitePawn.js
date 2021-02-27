"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
exports.__esModule = true;
exports.WhitePawn = void 0;
var ChessPiece_1 = require("./ChessPiece");
var Piece_1 = require("./Piece");
var WhitePawn = /** @class */ (function (_super) {
    __extends(WhitePawn, _super);
    function WhitePawn() {
        var _this = _super.call(this, Piece_1.PieceType.Pawn, true) || this;
        _this.generateMoves = function (moveOn, loc) {
            var wPawnMoves = [];
            //we'll generate 4 "position" objects that represent different directions the bishop might move
            //then try those one at a time and add the results
            var wPawnDirections = [];
            // first we know that the first move that the pawn can make is 1 or 2
            // after the first move it cannot go two but ONLY 1
            // we must check if the diagonal down has a piece that we can capture
            // if it goes all the way to the row we can switch to a desired pieace.
            var loc3 = { row: (loc.row + 1), col: (loc.col) };
            if (moveOn.pieceAt(loc3) === null)
                wPawnDirections.push({ row: 1, col: 0 });
            if (loc.row === 1)
                wPawnDirections.push({ row: 2, col: 0 });
            var loc1 = { row: (loc.row + 1), col: (loc.col + 1) };
            var loc2 = { row: (loc.row + 1), col: (loc.col - 1) };
            if (moveOn.pieceAt(loc1) !== null && moveOn.pieceAt(loc1) !== undefined && !moveOn.pieceAt(loc1).isWhite) // && IS NOT A BLACK PAWN
                wPawnDirections.push({ row: 1, col: 1 });
            if (moveOn.pieceAt(loc2) !== null && moveOn.pieceAt(loc2) !== undefined && !moveOn.pieceAt(loc2).isWhite) // && IS NOT A BLACK PAWN
                wPawnDirections.push({ row: 1, col: -1 });
            for (var _i = 0, wPawnDirections_1 = wPawnDirections; _i < wPawnDirections_1.length; _i++) {
                var direction = wPawnDirections_1[_i];
                var directionMoves = WhitePawn.slidePiece(moveOn, loc, direction, _this.isWhite);
                wPawnMoves.push.apply(wPawnMoves, directionMoves);
            }
            return wPawnMoves;
        };
        return _this;
    }
    WhitePawn.isOnBoard = function (loc) {
        return loc.col >= 0 && loc.col < 8 && loc.row >= 0 && loc.row < 8;
    };
    WhitePawn.slidePiece = function (moveOn, loc, dir, isWhite) {
        var allMoves = [];
        var currentLoc = { row: loc.row + dir.row, col: loc.col + dir.col };
        if (WhitePawn.isOnBoard(currentLoc) && moveOn.pieceAt(currentLoc) === null) {
            allMoves.push({ from: loc, to: currentLoc });
            currentLoc = { row: currentLoc.row + dir.row, col: currentLoc.col + dir.col };
        }
        if (moveOn.pieceAt(currentLoc) !== null && WhitePawn.isOnBoard(currentLoc)) {
            if (moveOn.pieceAt(currentLoc).isWhite != isWhite) {
                allMoves.push({ from: loc, to: currentLoc });
            }
        }
        return allMoves;
    };
    return WhitePawn;
}(ChessPiece_1.ChessPiece));
exports.WhitePawn = WhitePawn;
