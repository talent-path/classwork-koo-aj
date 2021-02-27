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
exports.BlackPawn = void 0;
var ChessPiece_1 = require("./ChessPiece");
var Piece_1 = require("./Piece");
var BlackPawn = /** @class */ (function (_super) {
    __extends(BlackPawn, _super);
    function BlackPawn() {
        var _this = _super.call(this, Piece_1.PieceType.Pawn, false) || this;
        _this.generateMoves = function (moveOn, loc) {
            var bPawnMoves = [];
            //we'll generate 4 "position" objects that represent different directions the bishop might move
            //then try those one at a time and add the results
            var bPawnDirections = [];
            // first we know that the first move that the pawn can make is 1 or 2
            // after the first move it cannot go two but ONLY 1
            // we must check if the diagonal down has a piece that we can capture
            // if it goes all the way to the row we can switch to a desired pieace.
            var loc3 = { row: (loc.row - 1), col: (loc.col) };
            if (moveOn.pieceAt(loc3) === null)
                bPawnDirections.push({ row: -1, col: 0 });
            if (loc.row === 6)
                bPawnDirections.push({ row: -2, col: 0 });
            var loc1 = { row: (loc.row - 1), col: (loc.col - 1) };
            var loc2 = { row: (loc.row - 1), col: (loc.col + 1) };
            if (moveOn.pieceAt(loc1) !== null && moveOn.pieceAt(loc1) !== undefined && moveOn.pieceAt(loc1).isWhite) // && IS NOT A BLACK PAWN
                bPawnDirections.push({ row: -1, col: -1 });
            if (moveOn.pieceAt(loc2) !== null && moveOn.pieceAt(loc2) !== undefined && moveOn.pieceAt(loc2).isWhite) // && IS NOT A BLACK PAWN
                bPawnDirections.push({ row: -1, col: 1 });
            for (var _i = 0, bPawnDirections_1 = bPawnDirections; _i < bPawnDirections_1.length; _i++) {
                var direction = bPawnDirections_1[_i];
                var directionMoves = BlackPawn.slidePiece(moveOn, loc, direction, _this.isWhite);
                bPawnMoves.push.apply(bPawnMoves, directionMoves);
            }
            return bPawnMoves;
        };
        return _this;
    }
    BlackPawn.isOnBoard = function (loc) {
        return loc.col >= 0 && loc.col < 8 && loc.row >= 0 && loc.row < 8;
    };
    // xxxx
    // xxxx
    // xxxp
    // xxpr
    BlackPawn.slidePiece = function (moveOn, loc, dir, isWhite) {
        var allMoves = [];
        var currentLoc = { row: loc.row + dir.row, col: loc.col + dir.col };
        if (BlackPawn.isOnBoard(currentLoc) && moveOn.pieceAt(currentLoc) === null) {
            allMoves.push({ from: loc, to: currentLoc });
        }
        if (moveOn.pieceAt(currentLoc) !== null && BlackPawn.isOnBoard(currentLoc)) {
            if (moveOn.pieceAt(currentLoc).isWhite != isWhite) {
                allMoves.push({ from: loc, to: currentLoc });
            }
        }
        return allMoves;
    };
    return BlackPawn;
}(ChessPiece_1.ChessPiece));
exports.BlackPawn = BlackPawn;
// TODO HOW TO PROMOTE THE PAWN TO A PROMOTED PIECE ONCE IT REACHES THE TOP (ROW === 0)
